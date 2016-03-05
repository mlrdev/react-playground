package de.mlrdev.reactapi.api.rest;

import de.mlrdev.reactapi.api.domain.BlogPostItem;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Maps BlogItem to BlogItemRest
 */
@Component
public class BlogItemsRestMapper {

    public BlogPostItemRest mapToRest(BlogPostItem domainBlogPostItem) {
        Instant instant = Instant.ofEpochMilli(domainBlogPostItem.getLastModified());
        ZonedDateTime lastModified = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
        BlogPostItemRest blogItem = new BlogPostItemRest(domainBlogPostItem.getHeading(),
                                                          domainBlogPostItem.getText(),
                                                          lastModified);

        return blogItem;
    }

    public List<BlogPostItemRest> mapToRestItems(List<BlogPostItem> domainBlogPostItems) {
        return domainBlogPostItems.stream().map(this::mapToRest).collect(Collectors.toList());
    }
}
