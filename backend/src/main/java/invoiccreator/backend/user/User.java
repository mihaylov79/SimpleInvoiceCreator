package invoiccreator.backend.user;

import invoiccreator.backend.company.Company;
import jakarta.persistence.*;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private LocalDate birthDate;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @ManyToOne
    @JoinColumn(name = "employer_company_id")
    private Company employerCompany;

    @OneToMany(mappedBy = "responsiblePerson")
    private List<Company> ownedCompanies = new ArrayList<>();

}
