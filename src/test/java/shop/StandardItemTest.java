package shop;

import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StandardItemTest {
    private StandardItem item;

    @BeforeClass
    public static void classSetup() {
        System.out.println("I'm before class");
    }

    @AfterClass
    public static void classTeardown() {
        System.out.println("I'm after class");
    }

    @Before
    public void setUp() throws Exception {
//        arrange
        System.out.println("I'm before test");
        item = new StandardItem(0, "Tričko", 250, "Oblečení", 0);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("I'm after test");
    }

    @Test
    public void testToString() {
        System.out.println("I'm testing tostring.");
        assertEquals( "Item   ID 0   NAME Tričko   CATEGORY Oblečení   PRICE 250.0   LOYALTY POINTS 0", item.toString());
    }

    @Test
    public void getLoyaltyPoints() {

    }

    @Test
    public void setLoyaltyPoints() {
    }

    @Test
    public void testEquals() {
        Item item2 = new StandardItem(0, "Tričko", 250, "Oblečení", 0);
        assertEquals(item, item2);
    }

    @Test
    public void testNotEquals() {
        Item item2 = new StandardItem(0, "Trička", 500, "Oblečení", 0);
        assertNotEquals(item, item2);

        Item item3 = new StandardItem(0, "Tričko", 250, "Jídlo", 0);
        assertNotEquals(item, item3);
    }

    @Test(expected = NotCopyableException.class)
    public void copy() throws NotCopyableException {
        throw new NotCopyableException("this is exception!");
    }
}