package invoiceCreator.backend.InvoiceNumberCounter.service;

import invoiceCreator.backend.InvoiceNumberCounter.model.InvoiceNumberCounter;
import invoiceCreator.backend.book.model.InvoiceBook;
import invoiceCreator.backend.company.model.Company;

public interface InvoiceNumberCounterService {

    String generateInvoiceNumber(Company company,InvoiceBook book);

    InvoiceNumberCounter lockInvoiceCounter(Company company, InvoiceBook book);


}
