package dao;

import model.Product;

import java.util.List;

public interface IProductDao extends IGeneraDao<Product> {
    int countRecord();

    List<Product> findByName(String name);

}
