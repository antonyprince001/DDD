package domain;

import java.util.ArrayList;
import java.util.List;

public class CartCheckOutEvent {

    public Order createOrderOnCheckout(List<Item> items){
        List<Product> products = new ArrayList<>();
        for(int iter=0;iter<items.size();iter++){
            Item item = items.get(iter);
            for(int i=0;i< item.getQuantity();i++){
                products.add(new Product(item.getProduct().getName(),item.getProduct().getPrice()));
            }
        }
        return new Order(products);
    }
}
