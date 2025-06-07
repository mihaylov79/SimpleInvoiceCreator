package invoiceCreator.backend.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import invoiceCreator.backend.user.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateCompanyRequest {

    @NotBlank
    @Length(max = 60 , message = "Името не може да надвишава 60 символа")
    private String companyName;

    @NotBlank(message = "ЕИК е задължително поле")
    @Size(min = 9, max = 13, message = "ЕИК трябва да е между 9 и 13 символа")
    @JsonProperty("EIK")
    private String EIK;

    private boolean vatRegistered;

    @Size(max = 12, message = "Регистрацията по ЗДДС не може да бъде по дълга от 12 символа")
    private String vatN;

    @NotBlank
    @Size(max = 20, message = "Името на града не трябва да надвишава 20 символа")
    private String homeTown;

    @NotBlank
    private String address;

    @Email
    private String contactEmail;

    @NotBlank
    private String responsiblePerson;//МОЛ - на фирмата

    private User owner;

    private User accountant;

    private String bank;

    private String BIC;

    private String IBAN;

    private String bankDepartment;

}
