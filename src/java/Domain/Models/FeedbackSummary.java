package Domain.Models;

public class FeedbackSummary {
    private String facilityId;
    private double averageStarRating;
    private int numberOfFeedbacks;

    public FeedbackSummary() {
    }

    // Getters
    public String getFacilityId() {
        return facilityId;
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

    public void setAverageStarRating(double averageStarRating) {
        this.averageStarRating = averageStarRating;
    }

    public void setNumberOfFeedbacks(int numberOfFeedbacks) {
        this.numberOfFeedbacks = numberOfFeedbacks;
    }
}

