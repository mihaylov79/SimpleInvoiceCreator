package invoiceCreator.backend.book.service.Impl;

import invoiceCreator.backend.book.model.InvoiceBook;
import invoiceCreator.backend.book.repository.InvoiceBookRepository;
import invoiceCreator.backend.book.service.InvoiceBookService;
import invoiceCreator.backend.company.model.Company;
import invoiceCreator.backend.invoice.model.Invoice;
import invoiceCreator.backend.web.dto.CreateBookRequest;

import java.util.List;

public class InvoiceBookServiceImpl implements InvoiceBookService {

    private final InvoiceBookRepository repository;

    public InvoiceBookServiceImpl(InvoiceBookRepository repository) {
        this.repository = repository;
    }


    @Override
    public void createBook(CreateBookRequest bookRequest) {

    }

    @Override
    public void editBookDescription(String Description) {

    }

    @Override
    public void markBookAsInactive() {

    }

    @Override
    public void markBookAsActive() {

    }

    @Override
    public List<InvoiceBook> getCompanyBooksList(Company company) {
        return List.of();

        //TODO тази заявка трябва да бъде към Company -
        // вероятно трябва да добавя CompanyService за нея.
    }
}
