package invoiceCreator.backend.book.service;

import invoiceCreator.backend.book.model.InvoiceBook;
import invoiceCreator.backend.company.model.Company;
import invoiceCreator.backend.web.dto.CreateBookRequest;

import java.util.List;

public interface InvoiceBookService {


    void createBook(CreateBookRequest bookRequest);

    void editBookDescription(String Description);

    void markBookAsInactive();

    void markBookAsActive();

    List<InvoiceBook>getCompanyBooksList(Company company);

    String suggestBookN(Company company);
}
