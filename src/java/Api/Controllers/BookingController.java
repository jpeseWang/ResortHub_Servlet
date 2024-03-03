/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Api.Controllers;

import Domain.DTOs.BookingDto.CreateBookingDto;
import Domain.DTOs.BookingDto.CreateRentalContractDto;
import Domain.DTOs.PageDto.PageDto;
import Domain.DTOs.PageDto.PageQueryDto;
import Domain.Enums.UserRole;
import Domain.Exceptions.ConflictException;
import Domain.Models.Employee;
import Domain.Models.User;
import Services.EmployeeService;
import Services.BookingService;
import Domain.Models.Booking;
import Services.RentalContractService;
import Utils.SessionUtils;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class BookingController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BookingService bookingService = new BookingService();
        PageQueryDto pageQueryDto = new PageQueryDto(request);

        PageDto<Booking> bookingsPage = bookingService.getAllBookings(pageQueryDto);
        List<Booking> bookings = bookingsPage.getData();

        String id = request.getParameter("id");
        String action = request.getParameter("action");
        switch (action) {
            case "getMyBooking":

                User user = SessionUtils.getUserFromSession(request);
                if (user == null) {
                    response.sendRedirect("/ResortHub/components/Unauthorized.jsp");
                    return;
                }
                java.util.List<Booking> myBookings = bookingService.getBookingsOfCustomer(user.getCustomerId());
                request.setAttribute("bookings", myBookings);
                request.getRequestDispatcher("pages/MyBooking.jsp").forward(request, response);
                break;
            case "getAll":
                request.setAttribute("bookings", bookings);
                request.getRequestDispatcher("Admin/BookingManagement/ListBooking.jsp").forward(request, response);
                break;

            case "getById":
                Booking booking = bookingService.getBookingById(id);

                request.setAttribute("booking", booking);
                request.getRequestDispatcher("Admin/EmployeeManagement/UpdateEmployee.jsp").forward(request, response);
                break;

            case "delete":
                bookingService.deleteBooking(id);
                String message = "Delete booking successfully!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("components/SuccessToast.jsp").forward(request, response);
                break;

            default:
                request.getRequestDispatcher("Admin/BookingManagement/ListBooking.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String facilityType = request.getParameter("facilityType");
        String totalPrice = request.getParameter("total");
        BookingService bookingService = new BookingService();
        switch (action) {
            case "createBooking":
                CreateBookingDto createBookingDto = new CreateBookingDto(request);
                User user = SessionUtils.getUserFromSession(request);
                if (user == null) {
                    response.sendRedirect("/ResortHub/components/Unauthorized.jsp");
                    return;
                }
                if (user.getUserRole() == UserRole.Admin) {
                    response.sendRedirect("/ResortHub/components/Forbidden.jsp");
                    return;
                }
                createBookingDto.setCustomerId(user.getCustomerId());
                int bookingID = bookingService.createBooking(createBookingDto);

                if (facilityType == "Room") {
                    String message = "Create booking successfully!";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("components/SuccessToast.jsp").forward(request, response);
                } else {
                    request.setAttribute("bookingID", bookingID);
                    request.setAttribute("totalPrice", totalPrice);
                    request.getRequestDispatcher("pages/Facility/ContractForm.jsp").forward(request, response);
                }

                break;

            case "createContract":
                CreateRentalContractDto dto = new CreateRentalContractDto(request);
                RentalContractService rentalContractService = new RentalContractService();
                rentalContractService.createRentalContract(dto);
                String message = "Create contract successfully!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("components/SuccessToast.jsp").forward(request, response);

                break;

            default:

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
