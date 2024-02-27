package Utils;

import Domain.Models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionUtils {
    public static User getUserFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        User user = null;

        if (session != null) {
            user = (User) session.getAttribute("User");
        }

        return user;
    }
    public static logOut(){
        HttpSession session = request.getSession();
        session.removeAttribute("User");
        response.sendRedirect("/ResortHub/pages/Home/index.jsp");
   }
}
