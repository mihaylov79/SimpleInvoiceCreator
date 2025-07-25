package invoiceCreator.backend.book.repository;

import invoiceCreator.backend.book.model.InvoiceBook;
import invoiceCreator.backend.company.model.Company;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InvoiceBookRepository extends JpaRepository<InvoiceBook, UUID> {

    List<InvoiceBook> findAllByCompany(Company company, Sort sort);

    boolean findAllByBookN(String bookN);

    Optional<InvoiceBook> findByBookN(String generatedBookN);
}
