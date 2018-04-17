package shop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class OrderTest {

    Order order;
    LocalDateTime setupTime;

    @Before
    public void setUp() throws Exception {
        setupTime = LocalDateTime.now();
        DateTimeFactory.setTestNow(setupTime);
        order = new Order(new ShoppingCart(),"a", "b");
    }

    @After
    public void tearDown() throws Exception {
        DateTimeFactory.endTesting();
    }

    @Test
    public void getCreated() {
        assertEquals(setupTime, order.getCreated());
    }
}