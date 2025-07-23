package invoiceCreator.backend.book.repository;

import invoiceCreator.backend.book.model.InvoiceBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvoiceBookRepository extends JpaRepository<InvoiceBook, UUID> {


}
