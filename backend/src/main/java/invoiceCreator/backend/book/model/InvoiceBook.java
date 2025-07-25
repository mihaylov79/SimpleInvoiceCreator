package invoiceCreator.backend.book.model;

import invoiceCreator.backend.company.model.Company;
import invoiceCreator.backend.invoice.model.Invoice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class InvoiceBook {

    @Id
    private UUID id;

    @Column(unique = true,nullable = false)
    private String bookN;

    @Column
    private String description;

    @Column
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "bookNumber")
    List<Invoice> bookInvoices = new ArrayList<>();

    public void setCompany(Company company) {
        this.company = company;
    }
}
