package invoiceCreator.backend.company.service;

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
