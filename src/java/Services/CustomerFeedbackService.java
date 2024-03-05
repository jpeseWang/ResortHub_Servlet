package Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.DTOs.CustomerFeedbackDto.CreateCustomerFeedbackDto;
import Domain.DTOs.PageDto.PageDto;
import Domain.DTOs.PageDto.PageMetaDto;
import Domain.DTOs.PageDto.PageQueryDto;
import Domain.Enums.Order;
import Domain.Exceptions.ConflictException;
import Domain.Exceptions.NotFoundException;
import Domain.Models.Customer;
import Domain.Models.CustomerFeedback;
import Domain.Models.FeedbackSummary;
import Repositories.Common.RepositoryBase;
import Repositories.Entities.CustomerFeedbackEntity;

public class CustomerFeedbackService extends RepositoryBase<CustomerFeedbackEntity> {
    private CustomerService customerService;

    @Override
    protected String getTableName() {
        return "CustomerFeedbacks";
    }

    @Override
    protected CustomerFeedbackEntity createEntityFromResultSet(ResultSet rs) throws SQLException {
        return new CustomerFeedbackEntity(rs);
    }

    public CustomerFeedbackService() {
        customerService = new CustomerService();
    }

    public PageDto<CustomerFeedback> getFeedbacksOfFacility(PageQueryDto dto, String facilityId) {
        List<CustomerFeedback> customerFeedbacks = new ArrayList<>();
        List<CustomerFeedbackEntity> entities = super.getAllWithOffset(String.format("FacilityId = '%s'", facilityId), dto.getOffset(), dto.getPageSize(),
                dto.getOrder() == Order.ASC);
        int itemCount = super.getTotalCount(String.format("FacilityId = '%s'", facilityId));

        for (CustomerFeedbackEntity entity : entities) {
            customerFeedbacks.add(mapEntityToCustomerFeedback(entity));
        }

        PageMetaDto meta = new PageMetaDto(dto, itemCount);

        return new PageDto<>(customers, meta);
    }

    public PageDto<CustomerFeedback> getFeedbacksOfCustomer(PageQueryDto dto, String customerId) {
        List<CustomerFeedback> customerFeedbacks = new ArrayList<>();
        List<CustomerFeedbackEntity> entities = super.getAllWithOffset(String.format("CustomerId = '%s'", customerId), dto.getOffset(), dto.getPageSize(),
                dto.getOrder() == Order.ASC);
        int itemCount = super.getTotalCount(String.format("CustomerId = '%s'", customerId));

        for (CustomerFeedbackEntity entity : entities) {
            customerFeedbacks.add(mapEntityToCustomerFeedback(entity));
        }

        PageMetaDto meta = new PageMetaDto(dto, itemCount);

        return new PageDto<>(customers, meta);
    }

    public FeedbackSummary getFeedbackSummaryOfFacility(String facilityId) {
        List<CustomerFeedbackEntity> entities = super.getAll(String.format("FacilityId = '%s'", facilityId));
        
        FeedbackSummary feedbackSummary = new FeedbackSummary();
        feedbackSummary.setFacilityId(facilityId);
        feedbackSummary.setAverageStarRating(calculateAverageStarRating(entities));
        feedbackSummary.setNumberOfFeedbacks(entities.size());

        return feedbackSummary;
    }

    public void createCustomerFeedback(CreateCustomerFeedbackDto dto, String customerId) {
        String query = String.format(
                "INSERT INTO %s (BookingId,FacilityId,CustomerId,CustomerName,StarRating,Description) VALUES (?,?,?,?,?,?);",
                getTableName());

        Customer customer = customerService.getCustomerById(customerId);
        
        List<Object> params = new ArrayList<>();
        params.add(dto.getBookingId());
        params.add(dto.getFacilityId());
        params.add(customerId);
        params.add(customer.getFullName());
        params.add(dto.getStarRating());
        params.add(dto.getDescription());

        return super.executeNonQuery(query, params);
    }

    private double calculateAverageStarRating(List<CustomerFeedbackEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return 0.0;
        }

        double totalStarRating = 0.0;
        for (CustomerFeedbackEntity entity : entities) {
            if (entity.getStarRating() != null) {
                totalStarRating += entity.getStarRating();
            }
        }

        return totalStarRating / entities.size();
    }

    private CustomerFeedback mapEntityToCustomerFeedback(CustomerFeedbackEntity entity) {
        CustomerFeedback customerFeedback = new CustomerFeedback();
        customerFeedback.setId(entity.getId());
        customerFeedback.setBookingId(entity.getBookingId());
        customerFeedback.setFacilityId(entity.getFacilityId());
        customerFeedback.setCustomerId(entity.getCustomerId());
        customerFeedback.setCustomerName(entity.getCustomerName());
        customerFeedback.setStarRating(entity.getStarRating());
        customerFeedback.setDescription(entity.getDescription());

        return customerFeedback;
    }
}
