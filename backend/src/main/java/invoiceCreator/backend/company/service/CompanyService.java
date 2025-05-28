package invoiceCreator.backend.company.service;

import invoiceCreator.backend.web.dto.CreateCompanyRequest;

public interface CompanyService {

    void createNewCompany(CreateCompanyRequest request);

    void editCompanyProfile();

    void markCompanyAsNotActive();

    void addNewEmployee();

    void removeEmployee();
}
