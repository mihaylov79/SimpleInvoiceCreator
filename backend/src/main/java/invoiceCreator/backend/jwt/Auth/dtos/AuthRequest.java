package invoiceCreator.backend.jwt.Auth.dtos;

import lombok.Data;

@Data
public class AuthRequest {

    private String username;
    private String password;
}
