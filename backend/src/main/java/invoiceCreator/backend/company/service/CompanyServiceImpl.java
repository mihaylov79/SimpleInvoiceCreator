package invoiceCreator.backend.company.service;

import invoiceCreator.backend.common.exceptions.CompanyAlreadyExistException;
import invoiceCreator.backend.common.exceptions.CompanyNotFoundException;
import invoiceCreator.backend.company.model.Company;
import invoiceCreator.backend.company.repository.CompanyRepository;
import invoiceCreator.backend.web.dto.CompanyEditRequest;
import invoiceCreator.backend.web.dto.CreateCompanyRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .companyIsActive(true)
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
        Company company = getCompanyById(companyId);

//        DTOMapper.mapCompanyToEditRequest(company);

        company = company.toBuilder()
                .companyName(companyRequest.getCompanyName())
                .EIK(companyRequest.getEIK())
                .vatRegistered(companyRequest.isVatRegistered())
                .vatN(companyRequest.getVatN())
                .homeTown(companyRequest.getHomeTown())
                .address(companyRequest.getAddress())
                .companyIsActive(companyRequest.isCompanyIsActive())
                .contactEmail(companyRequest.getContactEmail())
                .responsiblePerson(companyRequest.getResponsiblePerson())
                .owner(companyRequest.getOwner())
                .accountant(companyRequest.getOwner())
                .bank(companyRequest.getBank())
                .BIC(companyRequest.getBIC())
                .IBAN(companyRequest.getIBAN())
                .bankDepartment(companyRequest.getBankDepartment())
                .build();

        repository.save(company);
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
    public List<Company> showAllCompanies() {
        return repository.findAll(Sort.by("companyName"));
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
