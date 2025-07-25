package invoiceCreator.backend.company.repository;

import invoiceCreator.backend.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {


    Optional<Company> findByCompanyNameAndEIK(String companyName, String eik);

    Optional<Company> findByEIK(String eik);
}
