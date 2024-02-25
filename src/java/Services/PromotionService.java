package Services;

import java.util.ArrayList;
import java.util.List;

import Domain.DTOs.CustomerDto.GetListOfVoucherRecipientCustomersDto;
import Domain.Enums.VoucherType;
import Domain.Models.Booking;
import Domain.Models.Customer;
import Domain.Models.VoucherRecipientCustomer;

public class PromotionService {
    private BookingService bookingService;
    private CustomerService customerService;

    public PromotionService() {
        bookingService = new BookingService();
        customerService = new CustomerService();
    }

    public List<VoucherRecipientCustomer> getListOfVoucherRecipientCustomers(
            GetListOfVoucherRecipientCustomersDto dto) {
        List<Booking> bookings = bookingService.getBookingsByYearAndMonth(dto.getYear(), dto.getMonth());

        int totalVouchers = dto.getNumTenPercentDiscountVouchers() + dto.getNumTwentyPercentDiscountVouchers()
                + dto.getNumFiftyPercentDiscountVouchers();

        List<VoucherRecipientCustomer> voucherRecipientCustomers = new ArrayList<>();
        VoucherType voucherType = VoucherType.TenPercent;

        for (int i = 0; i != Math.min(bookings.size(), totalVouchers); i++) {
            if (i == dto.getNumTenPercentDiscountVouchers()) {
                voucherType = VoucherType.TwentyPercent;
            } else if (i == dto.getNumTenPercentDiscountVouchers() + dto.getNumTwentyPercentDiscountVouchers()) {
                voucherType = VoucherType.FiftyPercent;
            }

            Customer customer = customerService.getCustomerById(bookings.get(i).getCustomerId());
            String customerFullName = customer != null ? customer.getFullName() : "";

            voucherRecipientCustomers
                    .add(new VoucherRecipientCustomer(bookings.get(i).getCustomerId(), customerFullName, voucherType));
        }

        return voucherRecipientCustomers;
    }
}
