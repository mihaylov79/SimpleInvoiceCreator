package invoiceCreator.backend.item;

import invoiceCreator.backend.web.dto.NewItemRequest;

public interface ItemService {

    void addItem(NewItemRequest request);
}
