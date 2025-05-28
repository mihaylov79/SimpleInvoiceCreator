package invoiceCreator.backend.company.model;

import invoiceCreator.backend.invoice.model.Invoice;
import invoiceCreator.backend.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "companies")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String EIK;

    @Column(name = "town", nullable = false)
    private String homeTown;

    @Column
    private String address;

    @Column(name = "responsible_person", nullable = false)
    private String responsiblePerson;

    @ManyToOne
    private User owner; //МОЛ - на фирмата


    //TODO - трябва ли да имам би-дирекшънъл релация за счетоводителя!
    // - задължително ли е счетоводителят да фигурира в базата!
    // - дали не е по-добре да имам счетоводство (фирма)
    @ManyToOne
    @JoinColumn(name = "accountant_id")
    private User accountant;

    @Column
    private String bank;
    @Column
    private String BIC;
    @Column
    private String IBAN;
    @Column
    private String bankDepartment;

    @OneToMany(mappedBy = "employerCompany")
    private List<User> employees = new ArrayList<>();

    @OneToMany(mappedBy = "billTo")
    private List<Invoice> incomingInvoices = new ArrayList<>();

    @OneToMany(mappedBy = "payTo")
    private List<Invoice> outgoingInvoices = new ArrayList<>();

    public void setAccountant(User accountant) {
        this.accountant = accountant;
    }

}
