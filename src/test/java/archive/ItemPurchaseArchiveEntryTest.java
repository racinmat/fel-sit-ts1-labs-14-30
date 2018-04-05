package archive;

import org.junit.Before;
import org.junit.Test;
import shop.Item;
import shop.StandardItem;

import static org.junit.Assert.*;

public class ItemPurchaseArchiveEntryTest {

    private ItemPurchaseArchiveEntry archiveEntry;

    @Before
    public void setUp() throws Exception {
//        arrange
        Item item = new StandardItem(0, "Monster", 35, "Energy drink", 0);
        archiveEntry = new ItemPurchaseArchiveEntry(item);
    }

    @Test
    public void increaseCountHowManyTimesHasBeenSold() {
//        assert
        assertEquals(0, archiveEntry.getCountHowManyTimesHasBeenSold());
//        act
        archiveEntry.increaseCountHowManyTimesHasBeenSold(1);
//        assert
        assertEquals(1, archiveEntry.getCountHowManyTimesHasBeenSold());
    }
}