/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Api.Controllers;

import Domain.DTOs.BookingDto.CreateBookingDto;
import Domain.Enums.UserRole;
import Domain.Exceptions.ConflictException;
import Domain.Models.Employee;
import Domain.Models.User;
import Services.EmployeeService;
import Services.BookingService;
import Domain.Models.Booking;
import Utils.SessionUtils;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BookingController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        BookingService bookingService = new BookingService();
        java.util.List<Booking> bookings = bookingService.getAllBookings();

        String id = request.getParameter("id");

        String action = request.getParameter("action");
        switch (action) {

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
        BookingService BookingService = new BookingService();
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
                BookingService.createBooking(createBookingDto);
                String message = "Create booking successfully!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("components/SuccessToast.jsp").forward(request, response);

                break;

            case "createContract":

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
