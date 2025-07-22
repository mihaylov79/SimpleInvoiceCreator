package invoiceCreator.backend.user.service;

import invoiceCreator.backend.company.model.Company;
import invoiceCreator.backend.user.model.User;
import invoiceCreator.backend.web.dto.UserRegisterRequest;

public interface UserService {

    void registerUser(UserRegisterRequest request);
    void changeActiveCompany(Company newActiveCompany);
    User getUserByUsername(String username);
}
