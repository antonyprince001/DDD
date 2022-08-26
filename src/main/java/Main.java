import domain.Cart;
import domain.Product;

import java.util.List;

public class Main {
    public static void main(String args[]){
        Cart cart = new Cart();
        Product product = new Product("IPad Pro");
        List<Product> products = cart.getProducts();
        System.out.println(products.get(0).getName());
    }
}
