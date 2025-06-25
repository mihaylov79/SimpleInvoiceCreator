package invoiceCreator.backend.user.service;

import invoiceCreator.backend.web.dto.UserRegisterRequest;

public interface UserService {

    void registerUser(UserRegisterRequest request);
}
