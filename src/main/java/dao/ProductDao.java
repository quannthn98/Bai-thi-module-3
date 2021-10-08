package dao;

import config.DBConnection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    private Connection connection = DBConnection.getConnection();



    private final String SELECT_ALL = "select * from productDetail";
    private final String SELECT_BY_ID = "select * from productDetail where id = ?";
    private final String FIND_BY_NAME = "select * from productDetail where name like ?";
    private final String INSERT = "insert into product(name, price, color, description, categoryId, quantity) value (?,?,?,?,?,?)";
    private final String UPDATE = "update product set name = ?, price = ?,description  = ?,color  = ?, categoryId = ?, quantity = ? where id = ?";
    private final String DELETE = "delete from product where id = ?";
    private final String COUNT_ALL_RECORD = "select count(id) from product";
    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int categoryId = resultSet.getInt("categoryId");
                String category = resultSet.getString("category");
                Product product = new Product(id ,name, price, quantity, color, description, categoryId, category);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            int quantity = resultSet.getInt("quantity");
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            int categoryId = resultSet.getInt("categoryId");
            String category = resultSet.getString("category");
            product = new Product(id, name, price, quantity, color, description, categoryId, category);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public boolean save(Product product) {
        boolean isSaved = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getColor());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setInt(5, product.getCategoryId());
            preparedStatement.setInt(6, product.getQuantity());

            isSaved = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    @Override
    public boolean update(int id, Product product) {
        boolean isUpdated = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getColor());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setInt(5, product.getCategoryId());
            preparedStatement.setInt(6, product.getQuantity());
            preparedStatement.setInt(7, id);

            isUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUpdated;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            isDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productName = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int categoryId = resultSet.getInt("categoryId");
                String category = resultSet.getString("category");
                Product product = new Product(id ,productName, price, quantity, color, description, categoryId, category);
                productList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public int countRecord() {
        int count = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_RECORD);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            count = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }
}
