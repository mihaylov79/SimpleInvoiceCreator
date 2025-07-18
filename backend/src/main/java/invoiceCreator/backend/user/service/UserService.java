package invoiceCreator.backend.user.service;

import invoiceCreator.backend.user.model.User;
import invoiceCreator.backend.web.dto.UserRegisterRequest;

public interface UserService {

    void registerUser(UserRegisterRequest request);
    User getUserByUsername(String username);
}
