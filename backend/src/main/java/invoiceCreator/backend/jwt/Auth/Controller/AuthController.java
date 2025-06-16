package invoiceCreator.backend.jwt.Auth.Controller;

import invoiceCreator.backend.jwt.Auth.Service.AuthService;
import invoiceCreator.backend.jwt.Auth.dtos.AuthRequest;
import invoiceCreator.backend.jwt.Auth.dtos.JwtResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    @Autowired
    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody AuthRequest request){

        String token = service.login(request.getUsername(), request.getPassword());

        return ResponseEntity.ok(new JwtResponse(token));

    }
}
