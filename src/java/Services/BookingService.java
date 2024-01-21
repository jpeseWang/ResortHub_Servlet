package Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.DTOs.BookingDto.CreateBookingDto;
import Domain.Models.Booking;
import Repositories.Common.RepositoryBase;
import Repositories.Entities.BookingEntity;

public class BookingService extends RepositoryBase<BookingEntity> {
    private CustomerService customerService;
    private FacilityService facilityService;

    @Override
    protected String getTableName() {
        return "Bookings";
    }

    @Override
    protected BookingEntity createEntityFromResultSet(ResultSet rs) throws SQLException {
        return new BookingEntity(rs);
    }

    public BookingService() {
        customerService = new CustomerService();
        facilityService = new FacilityService();
    }

    public List<Booking> getAllBookings() {
        List<Booking> Bookings = new ArrayList<>();
        List<BookingEntity> entities = super.getAll();

        for (BookingEntity entity : entities)
            Bookings.add(mapEntityToBooking(entity));

        return Bookings;
    }

    public Booking getBookingById(int id) {
        BookingEntity entity = super.getById(id);
        Booking booking = mapEntityToBooking(entity);

        booking.setCustomer(customerService.getCustomerById(entity.getCustomerId()));
        booking.setFacility(facilityService.getFacilityById(entity.getFacilityId()));

        return booking;
    }

    public void createBooking(CreateBookingDto dto) {
        String query = String.format(
                "INSERT INTO %s (BookingDate,StartDate,EndDate,CustomerId,FacilityId) VALUES (?,?,?,?,?);",
                getTableName());

        List<Object> params = new ArrayList<>();
        params.add(dto.getBookingDate());
        params.add(dto.getStartDate());
        params.add(dto.getEndDate());
        params.add(dto.getCustomerId());
        params.add(dto.getFacilityId());

        super.executeNonQuery(query, params);
    }

    private Booking mapEntityToBooking(BookingEntity entity) {
        Booking booking = new Booking();
        booking.setBookingDate(entity.getBookingDate());
        booking.setStartDate(entity.getStartDate());
        booking.setEndDate(entity.getEndDate());
        booking.setCustomerId(entity.getCustomerId());
        booking.setFacilityId(entity.getFacilityId());

        return booking;
    }
}
