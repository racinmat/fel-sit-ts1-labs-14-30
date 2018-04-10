package storage;

import helpers.ItemStub;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import shop.Item;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.HashMap;

import static org.junit.Assert.*;

public class StorageTest {

    private Storage storage;
    private ByteArrayOutputStream myOut = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        storage = new Storage();
        System.setOut(new PrintStream(myOut));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(System.out);
    }

    @Test
    public void insertItems() throws NoSuchFieldException, IllegalAccessException {
        Item item = new ItemStub();

        assertEquals(0, storage.getItemCount(item));

        storage.insertItems(item, 2);

        assertEquals(2, storage.getItemCount(item));

        Class<Storage> storageClass = Storage.class;
        Field privateStockField = storageClass.getDeclaredField("stock");
        privateStockField.setAccessible(true);
        HashMap<Integer, ItemStock> stock = (HashMap<Integer, ItemStock>) privateStockField.get(storage);

        assertEquals(1, stock.size());
    }

    @Test
    public void testPrintListOfStoredItems() {
        storage.printListOfStoredItems();
        assertEquals("STORAGE IS CURRENTLY CONTAINING:\r\n", myOut.toString());
//        System.out.println("já se vypíšu");
//        assertEquals("já se vypíšu\r\n", myOut.toString());
    }
}