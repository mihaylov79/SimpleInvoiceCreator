package invoiceCreator.backend.web.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateBookRequest {

//    @NotBlank(message = "Tова поле не може да бъде празно")
//    @Pattern(regexp = "//d+", message = "Полето може да съдржа само цифри")
//    @Length(min = 3,max = 3, message = "Номера на книгата трябва да бъде 4 цифри")
//    private String bookNumber;

    @Length(max = 255, message = "Това поле не може да надвишава 255 символа")
    private String description;
}
