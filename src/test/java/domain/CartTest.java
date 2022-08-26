package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

        cart.add(iPadPro);
        List<Product> products = cart.getProducts();

        assertEquals(products.get(0), iPadPro);
    }

    @Test
    void shouldAddHeroInkPenToCart() {
        Product heroInkPen = new Product("Hero Ink Pen");

        cart.add(heroInkPen);
        List<Product> products = cart.getProducts();

        assertEquals(products.get(0), heroInkPen);
    }
}