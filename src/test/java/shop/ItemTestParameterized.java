package shop;

import helpers.CSVfileReader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ItemTestParameterized {

    private int id;
    private String name;
    private float price;
    private String category;
    private boolean shouldBeSame;

    private Item item;

    public ItemTestParameterized(String id, String name, String price, String category, String shouldBeSame) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.price = Float.parseFloat(price);
        this.category = category;
        this.shouldBeSame = Boolean.parseBoolean(shouldBeSame);
        System.out.println("contstructor called");
    }

//    public ItemTestParameterized() {
//        System.out.println("contstructor called");
//    }

    @Before
    public void setUp() throws Exception {
        item = new StandardItem(id, name, price, category, 0);
    }

    @Test
    public void getName() {
        assertEquals(this.name, this.item.getName());
    }

    @Test
    public void getCategory() {
        assertEquals(this.category, this.item.getCategory());
    }

    @Test
    public void testEquals() {
        Item reference = new StandardItem(1, "zarovka", 30, "domaci potreby", 0);
        if (shouldBeSame) {
            assertEquals(reference, item);
        } else {
            assertNotEquals(reference, item);
        }
    }

    @Parameterized.Parameters(name = "id: {0}, name: {1}, category: {3}, price: {2}")
    public static Collection<String[]> data() throws IOException {
        return CSVfileReader.readCSVfileToCollection("C:\\Users\\Azathoth\\IdeaProjects\\unittests1430\\src\\test\\resources\\data.csv");
    }
}