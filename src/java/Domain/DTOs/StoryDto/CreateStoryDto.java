package Domain.DTOs.StoryDto;

import java.util.Date;

import Domain.Enums.CustomerStatus;
import Utils.ConvertUtils;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Date;

public class CreateStoryDto {
    private Date postDate;
    private String facilityId;
    private String facilityName;
    private String customerId;
    private String customerName;
    private CustomerStatus customerStatus;
    private String title;
    private String description;

    public CreateStoryDto(HttpServletRequest request) {
        postDate = ConvertUtils.convertStringToDate(request.getParameter("PostDate"));
        facilityId = request.getParameter("FacilityId");
        facilityName = request.getParameter("FacilityName");
        customerId = request.getParameter("CustomerId");
        customerName = request.getParameter("CustomerName");
        customerStatus = CustomerStatus.fromIndex(ConvertUtils.convertStringToInt(request.getParameter("CustomerStatus")));
        title = request.getParameter("Title");
        description = request.getParameter("Description");
    }

    // Getters
    public Date getPostDate() {
        return postDate;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

