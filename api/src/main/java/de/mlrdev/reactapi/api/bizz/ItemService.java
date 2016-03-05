package de.mlrdev.reactapi.api.bizz;

import java.util.List;

public interface ItemService<T> {
    List<T> getAll();

    T getById(String id);
}
