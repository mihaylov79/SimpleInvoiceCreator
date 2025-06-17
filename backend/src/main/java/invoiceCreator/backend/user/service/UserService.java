package invoiceCreator.backend.user.service;

import invoiceCreator.backend.web.dto.RegisterRequest;

public interface UserService {

    void registerUser(RegisterRequest request);
}
