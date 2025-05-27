package invoiceCreator.backend.invoice.model;

import invoiceCreator.backend.book.model.InvoiceBook;
import invoiceCreator.backend.common.CurrencyCode;
import invoiceCreator.backend.company.model.Company;
import invoiceCreator.backend.invoiceLine.model.InvoiceLine;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "invoices")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "invoice_number",nullable = false,unique = true)
    private String invoiceNumber;

    @Column(name = "invoice_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private InvoiceType invoiceType;

    @Column(name = "base_currency_code", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyCode baseCurrencyCode;  // напр. "EUR", "USD" и т.н.

    @Column(name = "total_sum_in_base_currency")
    private BigDecimal totalSumInBaseCurrency;


    @Column
    @Enumerated(EnumType.STRING)
    private CurrencyCode currency;

    @Column(name = "total")
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "bill_to_id", nullable = false)
    private Company billTo;

    @ManyToOne
    @JoinColumn(name = "pay_to_id", nullable = false)
    private Company payTo;


    @ManyToOne
    @JoinColumn(name = "book_number_id")
    private InvoiceBook bookNumber;

    @OneToMany(mappedBy = "invoice")
    List<InvoiceLine>lines = new ArrayList<>();

}
