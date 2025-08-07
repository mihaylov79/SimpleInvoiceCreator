package invoiceCreator.backend.item.service.Impl;

import invoiceCreator.backend.item.model.Item;
import invoiceCreator.backend.item.repository.ItemRepository;
import invoiceCreator.backend.item.service.ItemService;
import invoiceCreator.backend.web.dto.NewItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    @Autowired
    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }


    @Override
    public void addItem(NewItemRequest request) {

    }

    @Override
    public Item findItemById(UUID id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Артикул с идентификация [%s] не съществува в базата данни!".formatted(id)));
    }
}
