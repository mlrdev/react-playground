package de.mlrdev.reactapi.api.domain;

import java.util.Date;

/**
 * Represents a block post item.
 */
public class BlogPostItem {
    private final String heading;
    private final Long lastModified;
    private final String text;

    public BlogPostItem(String heading, Long lastModified, String text) {
        this.heading = heading;
        this.lastModified = lastModified;
        this.text = text;
    }

    public String getHeading() {
        return heading;
    }

    public String getText() {
        return text;
    }

    public Long getLastModified() {
        return lastModified;
    }
}
