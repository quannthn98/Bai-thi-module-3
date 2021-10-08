package service;

import dao.CategoryDao;
import model.Category;

import java.util.List;

public class CategoryService implements ICategoryService{
    CategoryDao categoryDao = new CategoryDao();
    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public boolean save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public boolean update(int id, Category category) {
        return categoryDao.update(id, category);
    }

    @Override
    public boolean delete(int id) {
        return categoryDao.delete(id);
    }
}
