package de.mlrdev.reactapi.api.rest;

import java.time.ZonedDateTime;

/**
 * POJO to use as REST resource.
 */
public class BlogPostItemRest {
    public final String heading;
    public final String text;
    public final ZonedDateTime lastModified;

    public BlogPostItemRest(final String heading,
                            final String text,
                            final ZonedDateTime lastModified) {
        this.heading = heading;
        this.text = text;
        this.lastModified = lastModified;
    }
}
