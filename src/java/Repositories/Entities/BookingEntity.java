package Repositories.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BookingEntity {
    private int id;
    private Date bookingDate;
    private Date startDate;
    private Date endDate;
    private int occupancy;
    private String customerId;
    private String facilityId;
    private String contractId;

    public BookingEntity(ResultSet rs) throws SQLException {
        this.id = rs.getInt("Id");
        this.bookingDate = rs.getDate("BookingDate");
        this.startDate = rs.getDate("StartDate");
        this.endDate = rs.getDate("EndDate");
        this.occupancy = rs.getInt("Occupancy");
        this.customerId = rs.getString("CustomerId");
        this.facilityId = rs.getString("FacilityId");
        this.contractId = rs.getString("ContractId");
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public String getContractId() {
        return contractId;
    }

    // Setter methods (if needed)

    // Other methods
}
