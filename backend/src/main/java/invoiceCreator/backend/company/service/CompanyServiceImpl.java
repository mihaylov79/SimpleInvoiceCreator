package invoiceCreator.backend.company.service;

import invoiceCreator.backend.common.exceptions.CompanyAlreadyExistException;
import invoiceCreator.backend.common.exceptions.CompanyNotFoundException;
import invoiceCreator.backend.company.model.Company;
import invoiceCreator.backend.company.repository.CompanyRepository;
import invoiceCreator.backend.web.dto.CompanyEditRequest;
import invoiceCreator.backend.web.dto.CreateCompanyRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository repository;

    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }


    @Override
    public void createNewCompany(CreateCompanyRequest request) {

        Optional<Company>existingCompany = repository.findByCompanyNameAndEIK(request.getCompanyName(), request.getEIK());

        if (existingCompany.isPresent()){
            throw new CompanyAlreadyExistException("Фирма с такова име или ЕИК вече съществува");
        }

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

    //Дали не трябва вместо по id да търсим по ЕИК
    @Override
    public void editCompanyProfile(UUID companyId, CompanyEditRequest companyRequest) {

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

    @Override
    public <List> Company showAllCompanies() {
        return null;
    }

    @Override
    public Company getCompanyById(UUID companyId) {
        return repository.findById(companyId)
                .orElseThrow(()->
                 new CompanyNotFoundException("Фирма с идентификация [%s] не съществува"
                 .formatted(companyId)));
    }

    @Override
    public Company getCompanyByEIK(String EIK) {
        return repository.findByEIK(EIK)
                .orElseThrow(() ->
                new CompanyNotFoundException("Фирма с идентификация [%s] не съществува"
                .formatted(EIK)));
    }


}
