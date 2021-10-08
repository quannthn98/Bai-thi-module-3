import dao.ProductDao;
import model.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product>  productList = new ArrayList<>();
        ProductService productDao = new ProductService();
        productList = productDao.findByName("phone");
        for (Product product: productList){
            System.out.println(product.getCategory());
        }
    }
}
