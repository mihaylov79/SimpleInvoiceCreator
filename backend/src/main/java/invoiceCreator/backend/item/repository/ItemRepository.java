package invoiceCreator.backend.item.repository;

import invoiceCreator.backend.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
}
