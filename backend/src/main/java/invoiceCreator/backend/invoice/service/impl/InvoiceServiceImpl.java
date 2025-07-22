package invoiceCreator.backend.invoice.service.impl;

import invoiceCreator.backend.common.CurrencyCode;
import invoiceCreator.backend.invoice.model.Invoice;
import invoiceCreator.backend.invoice.repository.InvoiceRepository;
import invoiceCreator.backend.invoice.service.InvoiceService;
import invoiceCreator.backend.invoiceLine.model.InvoiceLine;
import invoiceCreator.backend.user.model.User;
import invoiceCreator.backend.user.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository repository;
    private final UserServiceImpl userService;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository repository, UserServiceImpl userService) {
        this.repository = repository;
        this.userService = userService;
    }

    @Override
    public void createInvoice(Invoice invoiceToCreate) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User currentUser = userService.getUserByUsername(username);

        if (invoiceToCreate.getBookNumber() == null ){
            throw new RuntimeException("За да издадете фактура трябва да зададете книга!");
        }

        List<InvoiceLine> lines = invoiceToCreate.getLines().stream().map(l-> InvoiceLine.builder()
                .item(l.getItem())
                .quantity(l.getQuantity())
                .unitPrice(l.getItem().getUnitPrice())
                .totalLinePrice(l.getItem().getUnitPrice().multiply(BigDecimal.valueOf(l.getQuantity())))
                .build()).toList();

        BigDecimal total = lines.stream()
                .map(InvoiceLine::getTotalLinePrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        Invoice invoice = Invoice.builder()
                .invoiceType(invoiceToCreate.getInvoiceType())
                .billTo(invoiceToCreate.getBillTo())
                .payTo(currentUser.getActiveCompany())
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
        //TODO Да довърша метода - да проверя дали мога да вземам payTo
        // - директно през currentUser т.е. дали не ставя дума за List<Company> а не за Company!
        //TODO Да уточня ownedCompanies и employerCompany в User Entity (кое поле за какво се отнася) -
        // за да преценя как да подавам payTo в createInvoice метода
        // (един user може да е свързам с много компании и обратно,
        // но не е задължително да е owner)

    }

    @Override
    public void addNewLine() {

    }

    @Override
    public void editInvoice() {

    }
}
