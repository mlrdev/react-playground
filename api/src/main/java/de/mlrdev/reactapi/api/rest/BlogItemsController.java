package de.mlrdev.reactapi.api.rest;

import de.mlrdev.reactapi.api.domain.BlogPostItem;
import de.mlrdev.reactapi.api.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "blogitems")
public class BlogItemsController implements Controller<BlogPostItemRest> {

    private static final Logger LOG = LoggerFactory.getLogger(BlogItemsController.class);

    @Autowired
    private ItemService itemService;

    @Autowired
    BlogItemsRestMapper blockBlogItemsRestMapper;

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public List<BlogPostItemRest> getAll() {
        return blockBlogItemsRestMapper.mapToRestItems(itemService.getAll());
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public BlogPostItemRest getById(@PathVariable String id) {
        return blockBlogItemsRestMapper.mapToRest((BlogPostItem)itemService.getById(id));
    }
}
