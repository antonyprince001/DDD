package domain;

import java.util.Currency;
import java.util.List;

public class Order {

    private List<Product> products;


    public Order(List<Product> products) {
        this.products = products;
    }

    public Price totalCost(){
        float totalCost = 0.0f;
        for(Product product :products){
            totalCost += product.getPrice().getAmount() + product.getShippingCost();
        }
        return new Price(totalCost, Currency.getInstance("USD"));
    }

}
