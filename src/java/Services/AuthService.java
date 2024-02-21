package Services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.Date;

import Domain.DTOs.AuthDto.LoginPayloadDto;
import Domain.Exceptions.NotFoundException;
import Domain.Exceptions.UnauthorizedException;
import Domain.Models.User;

public class AuthService {
    private final String CLAIM_ROLE = "role";
    private final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
    private final SecretKey SECRET_KEY = MacProvider.generateKey(SIGNATURE_ALGORITHM);
    private final TemporalAmount TOKEN_VALIDITY = Duration.ofHours(4L);
    
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
        
        String accessToken = createToken(user.getUsername(), user.getUserRole().toString());

        return new LoginPayloadDto(user, accessToken);
    }

    /**
     * Builds a JWT with the given subject and role and returns it as a JWS signed
     * compact String.
     */
    public String createToken(String subject, String role) {
        final Instant now = Instant.now();
        final Date expiryDate = Date.from(now.plus(TOKEN_VALIDITY));
        return Jwts.builder()
                .setSubject(subject)
                .claim(CLAIM_ROLE, role)
                .setExpiration(expiryDate)
                .setIssuedAt(Date.from(now))
                .signWith(SIGNATURE_ALGORITHM, SECRET_KEY)
                .compact();
    }

    /**
     * Parses the given JWS signed compact JWT, returning the claims.
     * If this method returns without throwing an exception, the token can be
     * trusted.
     */
    public Jws<Claims> parseToken(String compactToken)
            throws ExpiredJwtException,
            UnsupportedJwtException,
            MalformedJwtException,
            SignatureException,
            IllegalArgumentException {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(compactToken);
    }
}
