package invoiceCreator.backend.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class CreateBookRequest {

    @NotBlank(message = "Tова поле не може да бъде празно")
    @Pattern(regexp = "//d+", message = "Полето може да съдржа само цифри")
    @Length(min = 4,max = 4, message = "Номера на книгата трябва да бъде 4 цифри")
    private String bookNumber;

    @Length(max = 255, message = "Това поле не може да надвишава 255 символа")
    private String Description;
}
