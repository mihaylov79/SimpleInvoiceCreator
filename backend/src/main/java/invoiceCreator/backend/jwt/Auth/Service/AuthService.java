package invoiceCreator.backend.jwt.Auth.Service;

import invoiceCreator.backend.jwt.JwtUtil;
import invoiceCreator.backend.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager manager;
    private final JwtUtil util;

    @Autowired
    public AuthService(AuthenticationManager manager, JwtUtil util) {
        this.manager = manager;
        this.util = util;
    }

    public String login(String username, String password) {

        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(username,password)
        );

        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();

        return util.generateToken(user.getUsername(),user.getId(),user.getRole());
    }
}
