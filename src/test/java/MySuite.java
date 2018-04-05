import archive.ItemPurchaseArchiveEntryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import shop.DiscountedItemTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ItemPurchaseArchiveEntryTest.class,
    DiscountedItemTest.class
})
public class MySuite {
}
