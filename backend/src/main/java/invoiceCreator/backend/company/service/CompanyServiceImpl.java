package invoiceCreator.backend.company.service;

import invoiceCreator.backend.company.model.Company;
import invoiceCreator.backend.company.repository.CompanyRepository;
import invoiceCreator.backend.web.dto.CreateCompanyRequest;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository repository;

    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }


    @Override
    public void createNewCompany(CreateCompanyRequest request) {
        Company company = Company.builder()
                .companyName(request.getCompanyName())
                .EIK(request.getEIK())
                .vatRegistered(request.isVatRegistered())
                .vatN(request.isVatRegistered() ? request.getVatN() : null)
                .homeTown(request.getHomeTown())
                .address(request.getAddress())
                .contactEmail(request.getContactEmail())
                .responsiblePerson(request.getResponsiblePerson())
                .owner(request.getOwner())
                .accountant(request.getAccountant())
                .bank(request.getBank())
                .BIC(request.getBIC())
                .IBAN(request.getIBAN())
                .bankDepartment(request.getBankDepartment())
                .build();

        repository.save(company);
    }

    @Override
    public void editCompanyProfile() {

    }

    @Override
    public void markCompanyAsNotActive() {

    }

    @Override
    public void addNewEmployee() {

    }

    @Override
    public void removeEmployee() {

    }
}
