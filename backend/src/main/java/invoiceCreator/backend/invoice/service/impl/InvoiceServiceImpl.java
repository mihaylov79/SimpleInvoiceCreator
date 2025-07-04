package invoiceCreator.backend.invoice.service.impl;

import invoiceCreator.backend.invoice.repository.InvoiceRepository;
import invoiceCreator.backend.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository repository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createInvoice() {
        //TODO Как да вземам пореден № за фактурата.
        // Как да отразя номера на книгата с фактури
    }

    @Override
    public void addNewLine() {

    }

    @Override
    public void editInvoice() {

    }
}
