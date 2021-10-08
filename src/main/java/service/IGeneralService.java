package service;

import model.Product;

import java.util.List;

public interface IGeneralService<T> {
    List<T> getAll();

    T findById(int id);

    boolean save(T t);

    boolean update(int id, T t);

    boolean delete(int id);
}
