package Api.Controllers.Employee;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Api.Validators.EmployeeValidator;
import Domain.DTOs.EmployeeDto.CreateEmployeeDto;
import Domain.DTOs.EmployeeDto.UpdateEmployeeDto;
import Domain.Exceptions.ConflictException;
import Domain.Models.Employee;
import Services.EmployeeService;

public class EmployeeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployeeService employeeService = new EmployeeService();
        String id = request.getParameter("id");
        try {
            Employee employee = employeeService.getEmployeeById(id);
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("Admin/Dashboard/UpdateEmployee.jsp").forward(request, response);
        } catch (Exception e) {

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployeeService employeeService = new EmployeeService();
        EmployeeValidator employeeValidator = new EmployeeValidator();

        List<String> validationErrors;
        List<Employee> employees = employeeService.getAllEmployees();
        String action = request.getParameter("action");
        String id = request.getParameter("Id");
        switch (action) {

            case "create":
                CreateEmployeeDto createEmployeeDto = new CreateEmployeeDto(request);
                request.setAttribute("formData", createEmployeeDto);
                validationErrors = employeeValidator.validateCreateEmployeeDto(createEmployeeDto);
                if (validationErrors.isEmpty()) {
                    try {
                        employeeService.createEmployee(createEmployeeDto);

                        String message = "Create employee successfully!";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("Admin/Dashboard/SuccessToast.jsp").forward(request, response);
                        return;
                    } catch (ConflictException ex) {
                        request.setAttribute("error", ex.getMessage());
                    }
                } else {
                    request.setAttribute("error", String.join(" - ", validationErrors));
                }
                request.getRequestDispatcher("Admin/Dashboard/CreateEmployee.jsp").forward(request, response);
                break;

            case "update":

                UpdateEmployeeDto updateEmployeeDto = new UpdateEmployeeDto(request);
                validationErrors = employeeValidator.validateUpdateEmployeeDto(updateEmployeeDto);
                if (validationErrors.isEmpty()) {
                    try {
                        employeeService.updateEmployee(id, updateEmployeeDto);
                        String message = "Update employee successfully!";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("Admin/Dashboard/SuccessToast.jsp").forward(request, response);

                    } catch (ConflictException ex) {
                        request.setAttribute("error", ex.getMessage());
                        request.getRequestDispatcher("Admin/Dashboard/UpdateEmployee.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("error", String.join(", ", validationErrors));
                    request.getRequestDispatcher("Admin/Dashboard/UpdateEmployee.jsp").forward(request, response);
                }

                break;

            default:

                request.getRequestDispatcher("Admin/Dashboard/CreateEmployee.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
