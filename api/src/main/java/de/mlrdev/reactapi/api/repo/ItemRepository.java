package de.mlrdev.reactapi.api.repo;

import java.util.List;

public interface ItemRepository<T> {

    /**
     * Find all <b>item</b>s.
     * @return
     */
    List<T> getAll();

    /**
     * Find the <b>item</b> by id.
     * @param id
     * @return
     */
    T getById(String id);
}
