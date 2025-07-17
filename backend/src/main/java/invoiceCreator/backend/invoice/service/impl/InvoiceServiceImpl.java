package invoiceCreator.backend.invoice.service.impl;

import invoiceCreator.backend.common.CurrencyCode;
import invoiceCreator.backend.invoice.model.Invoice;
import invoiceCreator.backend.invoice.repository.InvoiceRepository;
import invoiceCreator.backend.invoice.service.InvoiceService;
import invoiceCreator.backend.invoiceLine.model.InvoiceLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.InvocationEvent;
import java.math.BigDecimal;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository repository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createInvoice(Invoice invoiceToCreate) {

        List<InvoiceLine> lines = invoiceToCreate.getLines().stream().map(l-> InvoiceLine.builder()
                .item(l.getItem())
                .quantity(l.getQuantity())
                .unitPrice(l.getItem().getUnitPrice())
                .totalLinePrice(l.getItem().getUnitPrice().multiply(BigDecimal.valueOf(l.getQuantity())))
                .build()).toList();

//        BigDecimal total = lines.stream()
//                .map(InvoiceLine::getTotalLinePrice)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);


        Invoice invoice = Invoice.builder()
                .invoiceType(invoiceToCreate.getInvoiceType())
                .billTo(invoiceToCreate.getBillTo())
                .payTo(invoiceToCreate.getPayTo())
                .paid(invoiceToCreate.isPaid())
                .baseCurrencyCode(CurrencyCode.BGN)
                .bookNumber(invoiceToCreate.getBookNumber())
                .currency(invoiceToCreate.getCurrency())
                .lines(lines)
                .totalAmount(total)
                .totalSumInBaseCurrency(total)
                .build();

        lines.forEach(l-> l.setInvoice(invoice));

        repository.save(invoice);
        //TODO да видя пак метода не са сетнати тоталите !

    }

    @Override
    public void addNewLine() {

    }

    @Override
    public void editInvoice() {

    }
}
