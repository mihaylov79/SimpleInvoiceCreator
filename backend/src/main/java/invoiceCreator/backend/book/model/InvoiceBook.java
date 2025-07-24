package invoiceCreator.backend.book.model;

import invoiceCreator.backend.invoice.model.Invoice;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
public class InvoiceBook {

    @Id
    private UUID id;

    @Column(unique = true,nullable = false)
    private String bookN;

    @Column
    private String description;

    @Column
    private boolean active;

    @OneToMany(mappedBy = "bookNumber")
    List<Invoice> bookInvoices = new ArrayList<>();
}
