package invoiceCreator.backend.web.dto;

import invoiceCreator.backend.user.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
public class CompanyEditRequest {

    @NotBlank
    @Length(max = 60 , message = "Името не може да надвишава 60 символа")
    private String companyName;

    @NotBlank
    @Pattern(regexp = "//d{10}", message = "Полето трябва да съдържа 10 цифри")
    private String EIK;


    private boolean vatRegistered;

    @Size(max = 12, message = "Регистрацията по ЗДДС не може да бъде по дълга от 12 символа")
    private String vatN;

    @NotBlank
    @Size(max = 20, message = "Името на града не трябва да надвишава 20 символа")
    private String homeTown;

    @NotBlank
    private String address;

    private boolean companyIsActive;

    @Email
    private String contactEmail;

    @NotBlank
    private String responsiblePerson;

    private User owner;

    private User accountant;

    private String bank;

    private String BIC;

    private String IBAN;

    private String bankDepartment;

}
