package invoiceCreator.backend.user.model;

import invoiceCreator.backend.company.model.Company;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private LocalDate birthDate;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "employer_company_id")
    private Company employerCompany;

    @OneToMany(mappedBy = "owner")
    private List<Company> ownedCompanies = new ArrayList<>();

}
