package service;

import model.Product;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    int countRecord();

    List<Product> findByName(String name);
}
