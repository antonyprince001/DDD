package domain;

import domain.domain_service.PriceCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    Cart cart;
    Map<String,Price> competitorPrices;
    PriceCalculator priceCalculator;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        competitorPrices = new HashMap<>();
        competitorPrices.put("IPad Pro", new Price(50.0f,Currency.getInstance("USD")));
        priceCalculator = new PriceCalculator(competitorPrices,0.1f);
    }

    @Test
    void shouldAddIPadProToCart() {
        Product iPadPro = new Product("IPad Pro");
        Item item = new Item(iPadPro,1);
        cart.add(item);
        List<Item> items = cart.getItems();

        assertEquals(items.get(0),item);
    }

    @Test
    void shouldAddHeroInkPenToCart() {
        Product heroInkPen = new Product("Hero Ink Pen");
        Item item = new Item(heroInkPen,1);

        cart.add(item);
        List<Item> items = cart.getItems();

        assertEquals(items.get(0),item);
    }

    @Test
    void shouldAddTwoGMCricketBatToCart() {
        Product gMCricketBat = new Product("GM Cricket Bat");
        Item item = new Item(gMCricketBat,1);

        cart.add(item);
        List<Item> items = cart.getItems();

        assertEquals(items.get(0),item);

    }

    @Test
    void shouldRemoveItemFromCart() {
        Product iPadPro = new Product("IPad Pro");
        Item item = new Item(iPadPro,1);
        cart.add(item);
        List<Item> items = cart.getItems();
        cart.removeItem(item);

        assertTrue(items.isEmpty());
    }

    @Test
    void shouldReturnRemovedItemsFromCart() {
        Product iPadPro = new Product("IPad Pro");
        Item iPadProItem = new Item(iPadPro,1);
        cart.add(iPadProItem);

        Product gMCricketBat = new Product("GM Cricket Bat");
        Item gMCricketBatItem = new Item(gMCricketBat,1);
        cart.add(gMCricketBatItem);

        cart.removeItem(iPadProItem);

        assertTrue(cart.getRemovedItems().contains(iPadPro.getName()));

    }

    @Test
    void shouldNotBeEqualWhenCartHaveSameItems() {
        Product iPadPro = new Product("IPad Pro");
        Item iPadProItem = new Item(iPadPro,1);
        cart.add(iPadProItem);

        Cart newCart = new Cart();
        newCart.add(iPadProItem);

        assertNotEquals(cart,newCart);
    }


    @Test
    void shouldAddItemWithPriceToCart() {
        Price price = new Price(120.0f, Currency.getInstance("USD"));
        Product iPadPro = new Product("IPad Pro", price);
        Item iPadProItem = new Item(iPadPro,1);
        cart.add(iPadProItem);

        assertEquals(cart.getItems().get(0),iPadProItem);
        assertEquals(cart.getItems().get(0).getProduct().getPrice(),price);

    }

    @Test
    void shouldCreateProductWithDiscountPrice() {
        Price discountPrice = priceCalculator.getPriceFor("IPad Pro");
        Product iPadPro = new Product("IPad Pro", discountPrice);
        Item iPadProItem = new Item(iPadPro,1);
        cart.add(iPadProItem);

        assertEquals(cart.getItems().get(0),iPadProItem);
        assertEquals(cart.getItems().get(0).getProduct().getPrice(),discountPrice);
    }

    @Test
    void shouldCreateOrderWhenCartIsCheckedOut() {

    }
}