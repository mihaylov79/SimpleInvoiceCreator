package invoiceCreator.backend.web.dto;

import invoiceCreator.backend.common.CurrencyCode;
import invoiceCreator.backend.company.model.Company;
import invoiceCreator.backend.invoice.model.InvoiceType;
import jakarta.validation.constraints.NotBlank;

public class CreateInvoiceRequest {

    @NotBlank(message = "Трябва да уточните дали искате да издадете ф-ра или кредитно известие")
    private InvoiceType invoiceType;

    @NotBlank(message = "Моля уточнете валутата на сделката")
    private CurrencyCode currencyCode;

    @NotBlank(message = "Моля изберете фирма получател")
    private Company billTo;



    //TODO не е довърщено трябва да се добавят още полета
}
