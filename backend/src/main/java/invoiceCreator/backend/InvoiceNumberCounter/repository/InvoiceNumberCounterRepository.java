package invoiceCreator.backend.InvoiceNumberCounter.repository;

import invoiceCreator.backend.InvoiceNumberCounter.model.InvoiceNumberCounter;
import invoiceCreator.backend.book.model.InvoiceBook;
import invoiceCreator.backend.company.model.Company;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface InvoiceNumberCounterRepository extends JpaRepository<InvoiceNumberCounter, UUID> {

    Optional<InvoiceNumberCounter> findByCompanyAndBook(Company company, InvoiceBook book);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select c from InvoiceNumberCounter c where c.company= :company and c.book= :book")
    Optional<InvoiceNumberCounter>lockByCompanyAndBook (@Param("company") Company company , @Param("book") InvoiceBook book);
}
