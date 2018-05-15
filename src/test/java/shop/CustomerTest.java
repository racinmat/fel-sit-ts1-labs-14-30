package shop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("test customer", "test address");
    }

    @Test
    public void getLoyaltyPointsEmpty() {
        assertEquals(0, customer.getLoyaltyPoints());
    }

    @Test
    public void getLoyaltyPointsOneOrder() {
        StandardItem item = mock(StandardItem.class);
        when(item.getLoyaltyPoints()).thenReturn(2);
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(item);
        Order order = new Order(cart, customer.getName(), customer.getAddress());
        customer.addOrder(order);

        assertEquals(2, customer.getLoyaltyPoints());
    }

    @Test
    public void getLoyaltyPointsTwoOrders() {
        StandardItem item1 = mock(StandardItem.class);
        when(item1.getLoyaltyPoints()).thenReturn(2);
        ShoppingCart cart1 = new ShoppingCart();
        cart1.addItem(item1);
        Order order1 = new Order(cart1, customer.getName(), customer.getAddress());

        StandardItem item2 = mock(StandardItem.class);
        when(item2.getLoyaltyPoints()).thenReturn(5);
        ShoppingCart cart2 = new ShoppingCart();
        cart2.addItem(item2);
        Order order2 = new Order(cart2, customer.getName(), customer.getAddress());

        customer.addOrder(order1);
        customer.addOrder(order2);

        assertEquals(7, customer.getLoyaltyPoints());
    }
}