package processes;

import org.junit.Test;
import shop.*;
import storage.NoItemInStorage;
import storage.Storage;

import java.util.Calendar;

import static org.junit.Assert.*;

public class EshopProcessTest {

    public static final int ITEM_0_PRICE = 15000;
    public static final int ITEM_0_COUNT = 0;

    @Test(expected = NoItemInStorage.class)
    public void basicProcessTest() throws NoItemInStorage {
//        arrange
        Storage storage = new Storage();
        ShoppingCart cart = new ShoppingCart();
        Item item = new StandardItem(0, "Lenovo notebook", ITEM_0_PRICE, "notebook", 5);
//        assert
        assertTrue(storage.getStockEntries().isEmpty());
        assertEquals(0, cart.getItemsCount());
//        act
        storage.insertItems(item, ITEM_0_COUNT);
//        assert
        assertEquals(ITEM_0_COUNT, storage.getItemCount(item));
//        act
        cart.addItem(item);
//        assert
        assertEquals(1, cart.getItemsCount());
        assertEquals(ITEM_0_PRICE, cart.getTotalPrice(new Customer("anonymous", "4chan")));
        assertEquals(item, cart.getCartItems().get(0));
//        act
        Order order = new Order(cart, "První zákazník", "Příčná Ulice");
//        assert
        assertEquals(item, order.getItems().get(0));
//        act
        storage.processOrder(order);
//        assert
//        assertEquals(ITEM_0_COUNT - 1, storage.getItemCount(item));
    }
}
