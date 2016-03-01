package de.mlrdev.reactapi.api.service;

import java.io.IOException;
import java.util.List;

public interface ItemService<T> {

    /**
     * Finds all <b>item</b>s.
     * @return
     */
    List<T> getAll();

    /**
     * Finds the <b>item</b> by id.
     * @param id
     * @return
     */
    T getById(String id);
}
