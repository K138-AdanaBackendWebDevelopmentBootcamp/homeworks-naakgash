package dev.patika.repositories;

import java.util.List;

// CRUD --> Create, Read, Update, Delete
public interface CrudRepository<T> {
    List<T> findAll();

    T findById(int id);

    void saveToDataBase(T object);

    void deleteFromDataBase(T Object);

    void deleteFromDataBase(int id);

    void updateOnDataBase(T Object);
}
