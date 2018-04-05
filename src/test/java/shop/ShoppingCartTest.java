package shop;

import helpers.ItemStub;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
        assertEquals(0, cart.getTotalPrice());

//        act
//        Item item = new StandardItem(1, "a", 10, "b", 0);
//        Item item = new ItemStub(1, "a", 10, "b");
        Item item = mock(Item.class);
        when(item.getPrice()).thenReturn((float) 10);

        cart.addItem(item);

//        assert
        assertEquals(10, cart.getTotalPrice());
        verify(item, times(1)).getPrice();
        verify(item, never()).setPrice(anyFloat());

    }
}