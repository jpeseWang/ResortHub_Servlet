package Domain.Models;

import java.math.BigDecimal;

public class FeedbackSummary {
    private String facilityId;
    private String name;
    private String imgSrc;
    private float area;
    private BigDecimal rentalCost;
    private double averageStarRating;
    private int numberOfFeedbacks;

    public FeedbackSummary() {
    }

    // Getters
    public String getFacilityId() {
        return facilityId;
    }

    public String getName() {
        return name;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public float getArea() {
        return area;
    }

    public BigDecimal getRentalCost() {
        return rentalCost;
    }

    public double getAverageStarRating() {
        return averageStarRating;
    }

    public int getNumberOfFeedbacks() {
        return numberOfFeedbacks;
    }

    // Setters
    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public void setRentalCost(BigDecimal rentalCost) {
        this.rentalCost = rentalCost;
    }

    public void setAverageStarRating(double averageStarRating) {
        this.averageStarRating = averageStarRating;
    }

    public void setNumberOfFeedbacks(int numberOfFeedbacks) {
        this.numberOfFeedbacks = numberOfFeedbacks;
    }
}
