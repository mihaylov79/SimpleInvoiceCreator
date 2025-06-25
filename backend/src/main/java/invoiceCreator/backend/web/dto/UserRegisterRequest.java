package invoiceCreator.backend.web.dto;

import invoiceCreator.backend.company.model.Company;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRegisterRequest {

    @NotBlank(message = "Това поле не може да бъде празно")
    private String username;
    @NotBlank(message = "Това поле не може да бъде празно")
    private String password;
    @Size(max = 20, message = "Името не може да бъде повече от 20 символа")
    private String firstName;
    @Size(max = 20, message = "Фамилията не може да бъде повече от 20 символа")
    private String lastName;
    @Email(message = "Моля въведете валиден мейл")
    private String email;

    private LocalDate birthdate;

    private Company company;
}
