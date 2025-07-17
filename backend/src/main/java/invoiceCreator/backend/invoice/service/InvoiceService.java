package invoiceCreator.backend.invoice.service;

import invoiceCreator.backend.invoice.model.Invoice;

public interface InvoiceService {

    void createInvoice(Invoice createInvoiceRequest);

    void addNewLine();

    void editInvoice();
}


