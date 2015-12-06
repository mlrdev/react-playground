package de.mlrdev.reactapi.api;

/**
 * Represents a Gem.
 */
public class Gem {
    public String name;
    public Number price;
    public String description;

    public Gem(String name, Number price, String description) {

        this.name = name;
        this.price = price;
        this.description = description;
    }
}
