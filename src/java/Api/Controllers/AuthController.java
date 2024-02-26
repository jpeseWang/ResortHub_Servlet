package Api.Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import Domain.Exceptions.NotFoundException;
import Domain.Exceptions.UnauthorizedException;
import Services.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthController extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        AuthService authService = new AuthService();

        String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        if (username == null || password == null) {
            response.sendRedirect("/ResortHub/components/Unauthorized.jsp");
            return;
        }

        try {
            authService.login(request, username, password);
        } catch (UnauthorizedException | NotFoundException ex) {
            response.sendRedirect("/ResortHub/components/Unauthorized.jsp");
            return;
        }

        response.sendRedirect("/ResortHub/pages/Home/index.jsp");
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
