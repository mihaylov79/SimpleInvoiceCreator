package invoiceCreator.backend.invoiceLine.repository;

import invoiceCreator.backend.invoiceLine.model.InvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface InvoiceLineRepository extends JpaRepository<InvoiceLine, UUID> {


}
