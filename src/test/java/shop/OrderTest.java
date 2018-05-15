package shop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static shop.ShoppingCart.POINTS_PER_DISCOUNT;

public class OrderTest {

    Order order;
    LocalDateTime setupTime;

    @Before
    public void setUp() throws Exception {
        setupTime = LocalDateTime.now();
        DateTimeFactory.setTestNow(setupTime);
        order = new Order(new ShoppingCart(),"a", "b");
    }

    @After
    public void tearDown() throws Exception {
        DateTimeFactory.endTesting();
    }

    @Test
    public void getCreated() {
        assertEquals(setupTime, order.getCreated());
    }

    @Test
    public void processOrderAfterDiscount() {
        Customer customer = new Customer("a", "b");
        ShoppingCart cart0 = new ShoppingCart();
        Item item0 = mock(Item.class);
        when(item0.getPrice()).thenReturn(1000f);
        when(item0.getLoyaltyPoints()).thenReturn(POINTS_PER_DISCOUNT);
        cart0.addItem(item0);
        Order oldOrder = new Order(cart0, customer.getName(), customer.getAddress());

        oldOrder.processOrder(customer);

        assertEquals(POINTS_PER_DISCOUNT, customer.getLoyaltyPoints());

        ShoppingCart cart = new ShoppingCart();
        Item item = mock(Item.class);
        when(item.getPrice()).thenReturn(1000f);
        order = new Order(cart, customer.getName(), customer.getAddress());
        order.processOrder(customer);

        assertEquals(0, customer.getLoyaltyPoints());
    }
}