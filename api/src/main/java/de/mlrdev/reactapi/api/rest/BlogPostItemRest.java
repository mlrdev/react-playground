package de.mlrdev.reactapi.api.rest;

import java.time.LocalDateTime;

/**
 * POJO to use as REST resource.
 */
public class BlogPostItemRest {

    public final LocalDateTime lastModified;
    public final String heading;
    public final String text;

    public BlogPostItemRest(final String heading,
                            final String text,
                            final LocalDateTime lastModified) {
        this.heading = heading;
        this.text = text;
        this.lastModified = lastModified;
    }
}
