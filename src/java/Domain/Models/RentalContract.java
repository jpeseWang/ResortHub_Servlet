package Domain.Models;

import java.math.BigDecimal;

public class RentalContract {
    private int id;
    private String customerId;
    private BigDecimal deposit;
    private BigDecimal totalAmount;

    public RentalContract() {
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
