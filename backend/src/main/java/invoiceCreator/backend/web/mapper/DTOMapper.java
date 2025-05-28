package invoiceCreator.backend.web.mapper;

import invoiceCreator.backend.company.model.Company;
import invoiceCreator.backend.web.dto.CompanyEditRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DTOMapper {

public static CompanyEditRequest mapCompanyToEditRequest(Company company){

return CompanyEditRequest.builder()
        .companyName(company.getCompanyName())
        .EIK(company.getEIK())
        .vatRegistered(company.isVatRegistered())
        .vatN(company.getVatN())
        .homeTown(company.getHomeTown())
        .address(company.getAddress())
        .contactEmail(company.getContactEmail())
        .responsiblePerson(company.getResponsiblePerson())
        .owner(company.getOwner())
        .accountant(company.getAccountant())
        .bank(company.getBank())
        .BIC(company.getBIC())
        .IBAN(company.getIBAN())
        .bankDepartment(company.getBankDepartment())
        .build();
}
}
