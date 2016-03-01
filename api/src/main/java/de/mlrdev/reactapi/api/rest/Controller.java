package de.mlrdev.reactapi.api.rest;

import java.util.List;

public interface Controller<T> {
    List<T> getAll();
    T getById(String id);
}
