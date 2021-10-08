package service;

import dao.ProductDao;
import model.Product;

import java.util.List;

public class ProductService implements IProductService {
    private ProductDao productDao = new ProductDao();
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        String target = "%"+name+"%";
        return productDao.findByName(target);
    }

    @Override
    public int countRecord() {
        return productDao.countRecord();
    }

    @Override
    public boolean save(Product product) {
        return productDao.save(product);
    }

    @Override
    public boolean update(int id, Product product) {
        return productDao.update(id, product);
    }

    @Override
    public boolean delete(int id) {
        return productDao.delete(id);
    }
}
