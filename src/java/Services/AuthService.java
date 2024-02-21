package Services;

import Domain.DTOs.AuthDto.LoginPayloadDto;
import Domain.Exceptions.NotFoundException;
import Domain.Exceptions.UnauthorizedException;
import Domain.Models.User;

public class AuthService {
    private UserService userService;

    public AuthService() {
        userService = new UserService();
    }

    public LoginPayloadDto login(String username, String password) throws UnauthorizedException, NotFoundException {
        User user = userService.getUserByUsername(username);

        if (user == null) {
            throw new NotFoundException("Username not found.");
        }

        if (!user.getPassword().equals(password)) {
            throw new UnauthorizedException("Username or Password incorrect");
        }

        return new LoginPayloadDto(user, "");
    }
}
