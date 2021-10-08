package dao;

import java.util.List;

public interface IGeneraDao<T> {
    List<T> getAll();

    T findById(int id);

    boolean save(T t);

    boolean update(int id, T t);

    boolean delete(int id);
}
