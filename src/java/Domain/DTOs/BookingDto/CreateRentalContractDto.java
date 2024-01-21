package Domain.DTOs.BookingDto;

import java.math.BigDecimal;

import jakarta.servlet.http.HttpServletRequest;

import Utils.ConvertUtils;

public class CreateRentalContractDto {
    private int bookingId;
    private BigDecimal deposit;
    private BigDecimal totalAmount;

    public CreateRentalContractDto(HttpServletRequest request) {
        bookingId = ConvertUtils.convertStringToInt(request.getParameter("BookingId"));
        deposit = ConvertUtils.convertStringToBigDecimal(request.getParameter("Deposit"));
        totalAmount = ConvertUtils.convertStringToBigDecimal(request.getParameter("TotalAmount"));
    }

    // Getters
    public int getBookingId() {
        return bookingId;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    // Setters
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
