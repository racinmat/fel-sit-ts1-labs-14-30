package shop;

import helpers.ItemStub;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static shop.ShoppingCart.DISCOUNT;
import static shop.ShoppingCart.POINTS_PER_DISCOUNT;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @Before
    public void setUp() throws Exception {
        cart = new ShoppingCart();
    }

    @Test
    public void addItem() {
    }

    @Test
    public void removeItem() {
    }

    @Test
    public void getItemsCount() {
//        assert
        assertEquals(0, cart.getItemsCount());
//        act
//        Item item = new StandardItem(1, "a", 10, "b", 0);
        Item item = new ItemStub(1, "a", 10, "b");
//        cart.addItem(item);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);

        cart.items = items;

//        assert
        assertEquals(1, cart.getItemsCount());
//        assertTrue(1 == cart.getItemsCount());
    }

    @Test
    public void getTotalPrice() {
//        assert
        assertEquals(0, cart.getTotalPrice(new Customer("anonymous", "4chan")));

//        act
//        Item item = new StandardItem(1, "a", 10, "b", 0);
//        Item item = new ItemStub(1, "a", 10, "b");
        Item item = mock(Item.class);
        when(item.getPrice()).thenReturn((float) 10);

        cart.addItem(item);

//        assert
        assertEquals(10, cart.getTotalPrice(new Customer("anonymous", "4chan")));
        verify(item, times(1)).getPrice();
        verify(item, never()).setPrice(anyFloat());

    }

    @Test
    public void getDiscountForNewCustomer() {
        assertEquals(0, cart.getDiscount(new Customer("anonymous", "4chan")));
    }

    @Test
    public void getDiscount() {
        Customer customer = mock(Customer.class);
        when(customer.getLoyaltyPoints()).thenReturn(POINTS_PER_DISCOUNT);

        assertEquals(DISCOUNT, cart.getDiscount(customer));
        verify(customer, times(1)).getLoyaltyPoints();
    }

    @Test
    public void getOriginalPrice() {
        Item item = mock(Item.class);
        when(item.getPrice()).thenReturn((float) 100);
        cart.addItem(item);
        assertEquals(100, cart.getOriginalPrice());
    }

    @Test
    public void getTotalPriceWithDiscount() {
        Item item = mock(Item.class);
        when(item.getPrice()).thenReturn((float) 1000);
        cart.addItem(item);
        Customer customer = mock(Customer.class);
        when(customer.getLoyaltyPoints()).thenReturn(POINTS_PER_DISCOUNT);
        assertEquals(1000 - DISCOUNT, cart.getTotalPrice(customer));
        verify(customer, times(1)).getLoyaltyPoints();
    }

    @Test
    public void getTotalPriceWithDiscountFree() {
        Item item = mock(Item.class);
        when(item.getPrice()).thenReturn((float) 20);
        cart.addItem(item);
        Customer customer = mock(Customer.class);
        when(customer.getLoyaltyPoints()).thenReturn(POINTS_PER_DISCOUNT);
        assertEquals(0, cart.getTotalPrice(customer));
        verify(customer, times(1)).getLoyaltyPoints();
    }

    @Test
    public void getTotalPriceWithDiscountTwoOrders() {
        Item item = mock(Item.class);
        when(item.getPrice()).thenReturn((float) 1000);
        cart.addItem(item);
        Customer customer = mock(Customer.class);
        when(customer.getLoyaltyPoints()).thenReturn(POINTS_PER_DISCOUNT, POINTS_PER_DISCOUNT, 0);

        assertEquals(1000 - DISCOUNT, cart.getTotalPrice(customer));
        verify(customer, times(1)).getLoyaltyPoints();

        Order order = new Order(cart, customer.getName(), customer.getAddress());

        order.processOrder(customer);
        verify(customer, times(1)).subtractPoints();

        Item item2 = mock(Item.class);
        when(item2.getPrice()).thenReturn((float) 2000);
        ShoppingCart cart2 = new ShoppingCart();
        cart2.addItem(item2);

        assertEquals(2000, cart2.getTotalPrice(customer));
    }


}