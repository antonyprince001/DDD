package domain;

import java.util.Currency;

public class Price {

    private Float amount;
    private Currency currency;

    public Price(Float amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Float getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

}



