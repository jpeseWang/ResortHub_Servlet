package Api.Controllers;

import Api.Validators.FacilityValidator;
import Domain.DTOs.EmployeeDto.CreateEmployeeDto;
import Domain.DTOs.EmployeeDto.UpdateEmployeeDto;
import Domain.DTOs.FacilityDto.CreateFacilityDto;
import Domain.Exceptions.ConflictException;
import Domain.Models.Employee;
import Domain.Models.Facility;
import Services.EmployeeService;
import Services.FacilityService;
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
        EmployeeService employeeService = new EmployeeService();

        java.util.List<Facility> facilities = facilityService.getAllFacilities();

        String id = request.getParameter("id");
        String action = request.getParameter("action");
        String facilityType = request.getParameter("facilityType");
       
        switch (action) {

            case "getMarketplaceItem":
                request.setAttribute("facilities", facilities);
                request.getRequestDispatcher("pages/Facility/Marketplace.jsp").forward(request, response);
                break;
            case "getAll":

                switch (facilityType) {
                    case "villa":
                        request.setAttribute("facilities", facilities);
                        request.getRequestDispatcher("Admin/FacilityManagement/Villa/ListVilla.jsp").forward(request, response);
                        break;
                    case "house":
                        request.setAttribute("facilities", facilities);
                        request.getRequestDispatcher("Admin/FacilityManagement/House/ListHouse.jsp").forward(request, response);
                        break;
                    case "room":
                        request.setAttribute("facilities", facilities);
                        request.getRequestDispatcher("Admin/FacilityManagement/Room/ListRoom.jsp").forward(request, response);
                        break;
                    default:
                        response.sendRedirect("Admin/FacilityManagement/ListFacility.jsp");
                }

                break;

            case "getById":
                Facility facility = facilityService.getFacilityById(id);
                request.setAttribute("facility", facility);
                request.getRequestDispatcher("pages/Facility/FacilityDetails.jsp").forward(request, response);
                break;

            case "delete":
                employeeService.deleteEmployee(id);
                String message = "Delete employee successfully!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("components/SuccessToast.jsp").forward(request, response);
                break;

            default:
                request.getRequestDispatcher("Admin/FacilityManagement/Villa/CreateVilla.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FacilityService facilityService = new FacilityService();
        FacilityValidator facilityValidator = new FacilityValidator();

        List<String> validationErrors;
        String action = request.getParameter("action");
        String facilityType = request.getParameter("facilityType");
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
                if (facilityType.equals("villa")) {
                    
                    request.getRequestDispatcher("Admin/FacilityManagement/Villa/CreateVilla.jsp").forward(request, response);
                } else if (facilityType.equals("house")) {
                    request.getRequestDispatcher("Admin/FacilityManagement/House/CreateHouse.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Admin/FacilityManagement/Room/CreateRoom.jsp").forward(request, response);
                }

                break;

            default:

                request.getRequestDispatcher("Admin/FacilityManagement/Villa/CreateVilla.jsp?").forward(request, response);
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
