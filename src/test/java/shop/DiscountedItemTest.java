package shop;

import helpers.ItemStub;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiscountedItemTest {

    private DiscountedItem item;

    @Before
    public void setUp() throws Exception {
        item = new DiscountedItem(1, "Ponožky", 20, "Oblečení", 10, "20.3.2018", "25.3.2018");
    }

    @Test
    public void testDiscountedPrice() {
        assertEquals(18, item.getDiscountedPrice(), 1e-8);
//        a == b
//        abs(a - b) < delta
    }

    @Test
    public void testEquals() {
        DiscountedItem item1 = new DiscountedItem(1, "vidlicky", (float) 20, "pribor", 10, "20.05.2018", "30.05.2018");
        DiscountedItem item2 = new DiscountedItem(1, "vidlicky", (float) 20, "pribor", 10, "20.05.2018", "30.05.2018");
        assertEquals(item1, item2);
    }

    @Test
    public void testNotEquals() {
        DiscountedItem item1 = new DiscountedItem(1, "vidlicky", (float) 20, "pribor", 10, "20.05.2018", "30.05.2018");
        DiscountedItem item2 = new DiscountedItem(2, "stul", (float) 30, "nabytek", 10, "20.05.2017", "30.05.2017");
        assertNotEquals(item1, item2);

        item1 = new DiscountedItem(1, "vidlicky", (float) 20, "pribor", 10, "20.05.2018", "30.05.2018");
        Item item3 = new ItemStub();
        assertNotEquals(item1, item3);

//        item1 = new DiscountedItem(1, "vidlicky", (float) 20, "pribor", 10, "20.05.2018", "30.05.2018");
//        item2 = new DiscountedItem(2, "vidlicky", (float) 20, "pribor", 10, "20.05.2018", "30.05.2018");
//        assertNotEquals(item1, item2);
//
//        item1 = new DiscountedItem(1, "vidlicky", (float) 20, "pribor", 10, "20.05.2018", "30.05.2018");
//        item2 = new DiscountedItem(1, "vidlicka", (float) 20, "pribor", 10, "20.05.2018", "30.05.2018");
//        assertNotEquals(item1, item2);
//
//        item1 = new DiscountedItem(1, "vidlicky", (float) 20, "pribor", 10, "20.05.2018", "30.05.2018");
//        item2 = new DiscountedItem(1, "vidlicky", (float) 30, "pribor", 10, "20.05.2018", "30.05.2018");
//        assertNotEquals(item1, item2);
//
//        item1 = new DiscountedItem(1, "vidlicky", (float) 20, "pribor", 10, "20.05.2018", "30.05.2018");
//        item2 = new DiscountedItem(1, "vidlicky", (float) 20, "pribory", 10, "20.05.2018", "30.05.2018");
//        assertNotEquals(item1, item2);
//
//        item1 = new DiscountedItem(1, "vidlicky", (float) 20, "pribor", 10, "20.05.2018", "30.05.2018");
//        item2 = new DiscountedItem(1, "vidlicky", (float) 20, "pribor", 10, "20.05.2017", "30.05.2018");
//        assertNotEquals(item1, item2);
//
//        item1 = new DiscountedItem(1, "vidlicky", (float) 20, "pribor", 10, "20.05.2018", "30.05.2018");
//        item2 = new DiscountedItem(1, "vidlicky", (float) 20, "pribor", 10, "20.05.2018", "30.05.2019");
//        assertNotEquals(item1, item2);
    }

}
