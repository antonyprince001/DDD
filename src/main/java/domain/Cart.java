package domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void add(Product product) {
        products.add(product);
    }

}
