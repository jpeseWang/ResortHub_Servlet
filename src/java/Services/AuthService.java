package Services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import Domain.Exceptions.NotFoundException;
import Domain.Exceptions.UnauthorizedException;
import Domain.Models.User;

public class AuthService {
    private UserService userService;

    public AuthService() {
        userService = new UserService();
    }

    public void login(HttpServletRequest request, String username, String password)
            throws UnauthorizedException, NotFoundException {
        User user = userService.getUserByUsername(username);

        if (user == null) {
            throw new NotFoundException("Username not found.");
        }

        HttpSession session = request.getSession();

        if (user.getPassword().equals(password)) {
            session.setAttribute("user", user);
        } else {
            throw new UnauthorizedException("Username or Password incorrect");
        }
    }
}
