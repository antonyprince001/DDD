package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    @Test
    void shouldAddIPadProToCart() {
        Product iPadPro = new Product("IPad Pro");

        cart.add(iPadPro,1);
        Map<Product,Integer> products = cart.getProducts();

        assertTrue(products.containsKey(iPadPro));
    }

    @Test
    void shouldAddHeroInkPenToCart() {
        Product heroInkPen = new Product("Hero Ink Pen");

        cart.add(heroInkPen,1);
        Map<Product,Integer> products = cart.getProducts();

        assertTrue(products.containsKey(heroInkPen));
    }

    @Test
    void shouldAddTwoGMCricketBatToCart() {
        Product gMCricketBat = new Product("GM Cricket Bat");

        cart.add(gMCricketBat,2);
        Map<Product,Integer> products = cart.getProducts();

        assertTrue(products.containsKey(gMCricketBat));
        assertEquals(products.get(gMCricketBat),2);

    }
}