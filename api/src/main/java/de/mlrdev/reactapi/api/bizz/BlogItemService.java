package de.mlrdev.reactapi.api.bizz;

import de.mlrdev.reactapi.api.domain.BlogPostItem;
import de.mlrdev.reactapi.api.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogItemService implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<BlogPostItem> getAll() {
        return itemRepository.getAll();
    }

    @Override
    public Object getById(String id) {
        return itemRepository.getById(id);
    }
}
