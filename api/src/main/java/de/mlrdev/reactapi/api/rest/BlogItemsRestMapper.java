package de.mlrdev.reactapi.api.rest;

import de.mlrdev.reactapi.api.domain.BlogPostItem;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Maps BlockItems to BlockItemsRest
 */
@Component
public class BlogItemsRestMapper {

    public BlogPostItemRest mapToRest(BlogPostItem domainItem) {
        Instant instant = Instant.ofEpochMilli(domainItem.getLastModified());
        LocalDateTime lastModified = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        BlogPostItemRest blockItem = new BlogPostItemRest(domainItem.getHeading(), domainItem.getText(), lastModified);

        return blockItem;
    }

    public List<BlogPostItemRest> mapToRestItems(List<BlogPostItem> domainItems) {
        return domainItems.stream().map(this::mapToRest).collect(Collectors.toList());
    }
}
