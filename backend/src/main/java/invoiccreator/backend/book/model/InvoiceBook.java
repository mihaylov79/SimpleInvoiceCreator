package invoiccreator.backend.book.model;

import invoiccreator.backend.invoice.model.Invoice;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class InvoiceBook {

    @Id
    private UUID id;

    @Column
    private String bookN;

    @Column
    private String description;

    @OneToMany(mappedBy = "bookNumber")
    List<Invoice> bookInvoices = new ArrayList<>();
}
