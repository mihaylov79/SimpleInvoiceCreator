package invoiceCreator.backend.web.dto;

import invoiceCreator.backend.user.model.User;
import lombok.Data;

@Data
public class CreateCompanyRequest {

    private String CompanyName;

    private String EIK;

    private String homeTown;

    private String address;

    private String responsiblePerson;//МОЛ - на фирмата

    private User owner;

    private User accountant;

    private String bank;

    private String BIC;

    private String IBAN;

    private String bankDepartment;

}
