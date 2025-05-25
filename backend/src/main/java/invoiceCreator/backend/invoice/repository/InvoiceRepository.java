package invoiceCreator.backend.invoice.repository;

import invoiceCreator.backend.invoice.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {
}
