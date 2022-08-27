package domain;

import java.util.Objects;

public class Product {

    private String name;

    private Price price;

    private ProductWeight productWeight;

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, Price price) {
        this.name = name;
        this.price = price;
        this.productWeight = new ProductWeight(10f,"Grams");
    }

    public ProductWeight getProductWeight() {
        return productWeight;
    }

    public Price getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public float getShippingCost(){
        return this.productWeight.getWeight()*0.1f;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getName().equals(product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
