package invoiceCreator.backend.company.repository;

import invoiceCreator.backend.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {


    Optional<Company> findByCompanyNameAndEIK(String companyName, String eik);

    Optional<Company> findByEIK(String eik);
}
