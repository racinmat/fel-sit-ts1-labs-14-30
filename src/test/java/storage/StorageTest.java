package storage;

import helpers.ItemStub;
import org.junit.Before;
import org.junit.Test;
import shop.Item;

import java.lang.reflect.Field;
import java.util.HashMap;

import static org.junit.Assert.*;

public class StorageTest {

    private Storage storage;

    @Before
    public void setUp() throws Exception {
        storage = new Storage();
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
}