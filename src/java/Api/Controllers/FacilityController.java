package Api.Controllers;

import Api.Validators.FacilityValidator;
import Domain.DTOs.BookingDto.CreateRentalContractDto;
import Domain.DTOs.CustomerFeedbackDto.CreateCustomerFeedbackDto;
import Domain.DTOs.FacilityDto.CreateFacilityDto;
import Domain.DTOs.PageDto.PageDto;
import Domain.DTOs.PageDto.PageQueryDto;
import Domain.Enums.FacilityType;
import Domain.Enums.UserRole;
import Domain.Exceptions.ConflictException;
import Domain.Models.Customer;
import Domain.Models.CustomerFeedback;
import Domain.Models.Facility;
import Domain.Models.FeedbackSummary;
import Domain.Models.MaintenanceFacility;
import Domain.Models.User;
import Services.CustomerFeedbackService;
import Services.CustomerService;
import Services.EmployeeService;
import Services.FacilityService;
import Utils.SessionUtils;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class FacilityController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FacilityController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FacilityController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FacilityService facilityService = new FacilityService();
        CustomerService customerService = new CustomerService();
        CustomerFeedbackService customerFeedbackService = new CustomerFeedbackService();

        PageQueryDto pageQueryDto;
        PageDto<Facility> pageDto;
        PageDto<CustomerFeedback> customerFeedback;
        PageDto<Customer> customerPageDto;

        String id = request.getParameter("id");
        String action = request.getParameter("action");
        String facilityType = request.getParameter("facilityType");

        pageQueryDto = new PageQueryDto(request);

        pageDto = facilityService.getAllFacilities(pageQueryDto);
        customerPageDto = customerService.getAllCustomers(pageQueryDto);
        switch (action) {

            case "getMarketplaceItem":
                request.setAttribute("facilities", pageDto.getData());
                request.setAttribute("meta", pageDto.getMeta());
                request.getRequestDispatcher("pages/Facility/Marketplace.jsp").forward(request, response);
                break;
            case "getAll":
                switch (facilityType) {
                    case "villa":

                        pageDto = facilityService.getAllFacilities(pageQueryDto, FacilityType.Villa);
                        request.setAttribute("facilities", pageDto.getData());
                        request.setAttribute("meta", pageDto.getMeta());
                        request.getRequestDispatcher("Admin/FacilityManagement/Villa/ListVilla.jsp").forward(request,
                                response);
                        break;
                    case "house":
                        pageDto = facilityService.getAllFacilities(pageQueryDto, FacilityType.House);
                        request.setAttribute("facilities", pageDto.getData());
                        request.setAttribute("meta", pageDto.getMeta());
                        request.getRequestDispatcher("Admin/FacilityManagement/House/ListHouse.jsp").forward(request,
                                response);
                        break;
                    case "room":
                        pageDto = facilityService.getAllFacilities(pageQueryDto, FacilityType.Room);
                        request.setAttribute("facilities", pageDto.getData());
                        request.setAttribute("meta", pageDto.getMeta());
                        request.getRequestDispatcher("Admin/FacilityManagement/Room/ListRoom.jsp").forward(request,
                                response);
                        break;
                    default:
                        response.sendRedirect("Admin/FacilityManagement/ListFacility.jsp");
                }

                break;

            case "getById":
                customerPageDto = customerService.getAllCustomers(pageQueryDto);
                Facility facility = facilityService.getFacilityById(id);
                customerFeedback = customerFeedbackService.getFeedbacksOfFacility(pageQueryDto, id);
                request.setAttribute("feedback", customerFeedback.getData());
                request.setAttribute("facility", facility);
                request.setAttribute("customers", customerPageDto.getData());
                request.getRequestDispatcher("pages/Facility/FacilityDetails.jsp").forward(request, response);
                break;


            case "getListMaintenance":

                java.util.List<MaintenanceFacility> maintenanceFacilityList = facilityService
                        .getFacilitiesForMaintenance(2024, 2);
                request.setAttribute("maintenanceFacility", maintenanceFacilityList);
                request.getRequestDispatcher("Admin/FacilityManagement/ListFacilityMaintenance.jsp").forward(request,
                        response);
                break;
            case "getCustomerFeedBack":

                request.setAttribute("meta", pageDto.getMeta());
                request.getRequestDispatcher("pages/Facility/Marketplace.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("Admin/FacilityManagement/Villa/CreateVilla.jsp").forward(request,
                        response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FacilityService facilityService = new FacilityService();
        CustomerFeedbackService customerFeedbackService = new CustomerFeedbackService();
        FacilityValidator facilityValidator = new FacilityValidator();

        List<String> validationErrors;
        String action = request.getParameter("action");
        String facilityType = request.getParameter("facilityType");

        User user = SessionUtils.getUserFromSession(request);
        switch (action) {
            case "create":
                CreateFacilityDto createFacilityDto = new CreateFacilityDto(request);
                request.setAttribute("facility", createFacilityDto);
                validationErrors = facilityValidator.validateCreateFacilityDto(createFacilityDto);
                if (validationErrors.isEmpty()) {
                    try {
                        facilityService.createFacility(createFacilityDto);

                        String message = "Create facility successfully!";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("components/SuccessToast.jsp").forward(request, response);
                        return;
                    } catch (ConflictException ex) {
                        request.setAttribute("error", ex.getMessage());
                    }
                } else {
                    request.setAttribute("error", String.join(" - ", validationErrors));
                }
                switch (facilityType) {
                    case "villa":
                        request.getRequestDispatcher("Admin/FacilityManagement/Villa/CreateVilla.jsp").forward(request,
                                response);
                        break;
                    case "house":
                        request.getRequestDispatcher("Admin/FacilityManagement/House/CreateHouse.jsp").forward(request,
                                response);
                        break;
                    default:
                        request.getRequestDispatcher("Admin/FacilityManagement/Room/CreateRoom.jsp").forward(request,
                                response);
                        break;
                }
                break;

            case "createCustomerFeedback":
                CreateCustomerFeedbackDto dto = new CreateCustomerFeedbackDto(request);

                String customerId;
                if ((user.getUserRole() == UserRole.Admin)) {
                    customerId = "KH-0000";
                } else {
                    customerId = user.getCustomerId();
                }
                customerFeedbackService.createCustomerFeedback(dto, customerId);
                String contractMessage = "Create Feedback successfully!";
                request.setAttribute("message", contractMessage);
                request.getRequestDispatcher("components/SuccessToast.jsp").forward(request, response);
                break;
            default:

                request.getRequestDispatcher("Admin/FacilityManagement/Villa/CreateVilla.jsp?").forward(request,
                        response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
