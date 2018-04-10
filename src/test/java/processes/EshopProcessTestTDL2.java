package processes;

import org.junit.Before;
import org.junit.Test;
import shop.Item;
import shop.Order;
import shop.ShoppingCart;
import shop.StandardItem;
import storage.NoItemInStorage;
import storage.Storage;
import static org.junit.Assert.*;

public class EshopProcessTestTDL2 {

    private static final int ITEM_ID = 0;
    private Storage storage;
    private ShoppingCart cart;
    private Item item;

    @Before
    public void setUp() throws Exception {
        storage = new Storage();
        cart = new ShoppingCart();
        item = new StandardItem(ITEM_ID, "Lenovo notebook", 15000, "notebook", 5);
    }

    @Test
    public void testCase1() throws NoItemInStorage {
        assertEquals(0, storage.getItemCount(item));
        assertEquals(0, cart.getItemsCount());
//        1
        storage.insertItems(item, 1);
        assertEquals(1, storage.getItemCount(item));
//        2
        cart.addItem(item);
        assertEquals(1, cart.getItemsCount());
//        3
        cart.removeItem(ITEM_ID);
        assertEquals(0, cart.getItemsCount());
//        2
        cart.addItem(item);
        assertEquals(1, cart.getItemsCount());
//        4
        Order order = new Order(cart, "test case 1 customer", "test case 1 adress");
        storage.processOrder(order);
        assertEquals(0, storage.getItemCount(item));
    }

    @Test(expected = NoItemInStorage.class)
    public void testCase2() throws NoItemInStorage {
        assertEquals(0, storage.getItemCount(item));
        assertEquals(0, cart.getItemsCount());
//        1
        storage.insertItems(item, 0);
        assertEquals(0, storage.getItemCount(item));
//        3
        cart.removeItem(ITEM_ID);
        assertEquals(0, cart.getItemsCount());
//        2
        cart.addItem(item);
        assertEquals(1, cart.getItemsCount());
//        2
        Item item2 = new StandardItem(3, "Asus notebook", 20000, "notebook", 10);
        cart.addItem(item2);
        assertEquals(2, cart.getItemsCount());
//        3
        cart.removeItem(ITEM_ID);
        assertEquals(1, cart.getItemsCount());
//        4
        Order order = new Order(cart, "test case 2 customer", "test case 2 adress");
        storage.processOrder(order);
    }

    @Test
    public void testCase3() throws NoItemInStorage {
        assertEquals(0, storage.getItemCount(item));
        assertEquals(0, cart.getItemsCount());
//        1
        storage.insertItems(item, 2);
        assertEquals(2, storage.getItemCount(item));
//        4
        Order order = new Order(cart, "test case 3 customer", "test case 3 adress");
        storage.processOrder(order);

        assertEquals(2, storage.getItemCount(item));
    }

}
