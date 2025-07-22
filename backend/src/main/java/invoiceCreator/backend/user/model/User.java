package invoiceCreator.backend.user.model;

import invoiceCreator.backend.company.model.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private LocalDate birthDate;

    @Column
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column
    private boolean active;

    //TODO да добавя полето в методите и да помисля дали да добавям
    // employerCompany кум connectedCompanies
    @ManyToOne
    @JoinColumn(name = "active_company_id")
    private Company activeCompany;

    @ManyToMany
    @JoinTable(
            name = "user_connected_companies",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    List<Company>connectedCompanies = new ArrayList<>();

    //Ако променя релацията на ManyToMany - ще имам възможност да свържа потребител с повече
    // от една компания , но трябва да променя и регистър метода и фронт енд-а
    // защото тогава това няма да е поле а List с фирми.
    @ManyToOne
    @JoinColumn(name = "employer_company_id")
    private Company employerCompany;

    @OneToMany(mappedBy = "owner")
    private List<Company> ownedCompanies = new ArrayList<>();

    public void setActiveCompany(Company activeCompany) {
        this.activeCompany = activeCompany;
    }

    //TODO Да уточня ownedCompanies и employerCompany (кое поле за какво се отнася) -
    // за да преценя как да подавам payTo в createInvoice метода
    // (един user може да е свързам с много компании и обратно,
    // но не е задължително да е owner)

}
