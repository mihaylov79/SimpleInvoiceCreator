package invoiceCreator.backend.book.repository;

import invoiceCreator.backend.book.model.InvoiceBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceBookRepository extends JpaRepository<InvoiceBook, UUID> {


}
