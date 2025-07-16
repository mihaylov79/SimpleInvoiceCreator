package invoiceCreator.backend.InvoiceNumberCounter.service.Impl;

import invoiceCreator.backend.InvoiceNumberCounter.model.InvoiceNumberCounter;
import invoiceCreator.backend.InvoiceNumberCounter.repository.InvoiceNumberCounterRepository;
import invoiceCreator.backend.InvoiceNumberCounter.service.InvoiceNumberCounterService;
import invoiceCreator.backend.book.model.InvoiceBook;
import invoiceCreator.backend.company.model.Company;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class InvoiceCounterServiceImpl implements InvoiceNumberCounterService {

    private final InvoiceNumberCounterRepository repository;

    public InvoiceCounterServiceImpl(InvoiceNumberCounterRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional
    public String generateInvoiceNumber(Company company, InvoiceBook book) {

        InvoiceNumberCounter counter = lockInvoiceCounter(company, book);

        int invoiceNumber = counter.getLastUsedNumber() + 1;
        counter.setLastUsedNumber(invoiceNumber);

        String bookPart = String.format("%03d",Integer.parseInt(book.getBookN()));
        String numberPart = String.format("%010d",invoiceNumber);

        return "B" + bookPart + "-" + numberPart;
    }

    @Override
    public InvoiceNumberCounter lockInvoiceCounter(Company company, InvoiceBook book) {
        return repository.lockByCompanyAndBook(company, book)
                .orElseThrow(()-> new RuntimeException("Не е открит брояч за подаданете Компания и книга"));
    }
}
