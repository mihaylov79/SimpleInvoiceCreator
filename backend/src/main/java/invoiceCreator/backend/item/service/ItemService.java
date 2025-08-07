package invoiceCreator.backend.item.service;

import invoiceCreator.backend.item.model.Item;
import invoiceCreator.backend.web.dto.NewItemRequest;

import java.util.UUID;

public interface ItemService {

    void addItem(NewItemRequest request);

    Item findItemById(UUID id);
}
