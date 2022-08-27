package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cart {

    private List<Item> items = new ArrayList<>();
    private Set<String> removedItems = new HashSet<>();

    private boolean isCheckedOut = false;

    public void add(Item item) {
        items.add(item);
        items.remove(item.getProduct().getName());
    }

    public List<Item> getItems() {
        return items;
    }

    public void removeItem(Item item){
        items.remove(item);
        removedItems.add(item.getProduct().getName());
    }

    public Set<String> getRemovedItems(){
        return removedItems;
    }

    public Order checkoutCart(){
        this.isCheckedOut = true;
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
