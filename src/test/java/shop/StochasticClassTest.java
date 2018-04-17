package shop;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StochasticClassTest {

    private StochasticClass randomWalk;

    @Before
    public void setUp() {
//        Random random = new Random(60);
//        Random random = ThreadLocalRandom.current();
//        random.setSeed(60);   //nefunguje
        Random random = mock(ThreadLocalRandom.class);
        when(random.nextDouble()).thenReturn(0.72, 0.98, 0.6);
        randomWalk = new StochasticClass(random);
//        System.out.println(random.nextDouble());
//        System.out.println(random.nextDouble());
//        System.out.println(random.nextDouble());
    }

    @Test
    public void testRandomWalk() {
        randomWalk.randomWalk();
        assertEquals(StochasticState.THIRD, randomWalk.getState());
    }

    @Test
    public void testRandomWalkTwice() {
        randomWalk.randomWalk();
        assertEquals(StochasticState.THIRD, randomWalk.getState());
        randomWalk.randomWalk();
        assertEquals(StochasticState.FOURTH, randomWalk.getState());
    }

    @Test
    public void testRandomWalkThreeTimes() {
        randomWalk.randomWalk();
        assertEquals(StochasticState.THIRD, randomWalk.getState());
        randomWalk.randomWalk();
        assertEquals(StochasticState.FOURTH, randomWalk.getState());
        randomWalk.randomWalk();
        assertEquals(StochasticState.THIRD, randomWalk.getState());
    }

    @Test
    public void testGetState() {
        assertEquals(StochasticState.FIRST, randomWalk.getState());
    }
}