package invoiceCreator.backend.InvoiceNumberCounter.model;

import invoiceCreator.backend.book.model.InvoiceBook;
import invoiceCreator.backend.company.model.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoice_counter", uniqueConstraints = @UniqueConstraint(columnNames = {"company_id" , "book_id"}))
public class InvoiceNumberCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private InvoiceBook book;

    @Column(name = "last_number", nullable = false)
    private int lastUsedNumber;


}
