package Services;

public class UserExperienceService {
    private BookingService bookingService;
    private CustomerFeedbackService customerFeedbackService;

    public UserExperienceService() {
        bookingService = new BookingService();
        customerFeedbackService = new CustomerFeedbackService();
    }
}
