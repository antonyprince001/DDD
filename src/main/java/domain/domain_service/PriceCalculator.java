package domain.domain_service;

import domain.Price;

import java.util.Map;

public class PriceCalculator {

    private Map<String, Price> competitorPrices;
    private float defaultDiscount;

    public PriceCalculator(Map<String, Price> competitorPrices, float defaultDiscount){
        this.competitorPrices = competitorPrices;
        this.defaultDiscount = defaultDiscount;
    }

    public Price getPriceFor(String productName) {
        Price competitorPrice = competitorPrices.get(productName);
        Float competitorAmount= competitorPrice.getAmount();
        return new Price(competitorAmount-competitorAmount*defaultDiscount,competitorPrice.getCurrency());
    }


}
