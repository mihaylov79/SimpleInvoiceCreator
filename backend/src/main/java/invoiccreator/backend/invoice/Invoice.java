package invoiccreator.backend.invoice;

import invoiccreator.backend.book.model.InvoiceBook;
import invoiccreator.backend.company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    @Column
    private String currency;

    @Column(name = "total")
    private String totalAmount;

    @ManyToOne
    @JoinColumn(name = "bill_to_id", nullable = false)
    private Company billTo;

    @ManyToOne
    @JoinColumn(name = "pay_to_id", nullable = false)
    private Company payTo;


    @ManyToOne
    @JoinColumn(name = "book_number_id")
    private InvoiceBook bookNumber;

}
