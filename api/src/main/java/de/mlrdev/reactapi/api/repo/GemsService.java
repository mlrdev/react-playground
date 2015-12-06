package de.mlrdev.reactapi.api.repo;

import de.mlrdev.reactapi.api.Gem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple persistence service that supplies gems.
 * Includes only Read-operations (out of C<b>R</b>UD) right now.
 */
@Component
public class GemsService {

    //TODO: CRUD operations

    //dummy repo
    private static final List<Gem> GEMS = new ArrayList<>();

    public GemsService() {
        GEMS.add(new Gem("Diamond", 100L, "Wittelsbach Diamond, 35.56-carat"));
        GEMS.add(new Gem("Red Opal", 10L, ""));
        GEMS.add(new Gem("Amber", 1L, "An ant inside A Baltic amber"));
    }

    public List<Gem> getAll() {
        return GEMS;
    }

    public Gem getById(int id) {
        return GEMS.get(id);
    }
}
