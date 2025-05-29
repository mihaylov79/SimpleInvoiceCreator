package invoiceCreator.backend.company.service;

import invoiceCreator.backend.company.model.Company;
import invoiceCreator.backend.web.dto.CompanyEditRequest;
import invoiceCreator.backend.web.dto.CreateCompanyRequest;

import java.util.UUID;

public interface CompanyService {

    void createNewCompany(CreateCompanyRequest request);

    void editCompanyProfile(UUID companyId, CompanyEditRequest companyRequest);

    void markCompanyAsNotActive();

    void addNewEmployee();

    void removeEmployee();

    <List>Company showAllCompanies();

    Company getCompanyById(UUID companyId);

    Company getCompanyByEIK(String EIK);
}
