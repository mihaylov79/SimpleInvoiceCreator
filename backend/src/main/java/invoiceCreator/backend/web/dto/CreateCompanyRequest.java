package invoiceCreator.backend.web.dto;

import invoiceCreator.backend.user.model.User;

public class CreateCompanyRequest {

    private String CompanyName;

    private String EIK;

    private String homeTown;

    private String address;
    //TODO Да помисля как да вземам МОЛ-а
    // - дали искам от юзъра String и да търся в репозиторито
    // - или да подам падащо меню със съществуващи клиенти!
    // - не е задължително МОЛ-а да е регистриран във нашият Софтуер!
    private User responsiblePerson; //МОЛ - на фирмата

    private String bank;

    private String BIC;

    private String IBAN;

    private String bankDepartment;

}
