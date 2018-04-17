package shop;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class StochasticClass {

    private Random random;
    private StochasticState state;
    private final double[][] probabilities = {
        {0.4, 0.3, 0.2, 0.1},
        {0.1, 0.2, 0.2, 0.5},
        {0.2, 0.2, 0.4, 0.2},
        {0.1, 0.1, 0.7, 0.1},
    };

    public StochasticClass(Random random) {
        this.state = StochasticState.FIRST;
        this.random = random;
    }

    public StochasticClass() {
        this(ThreadLocalRandom.current());
    }

    private StochasticState getStateForProbability(double probability) {
        double prob = 0;
        for (int i = 0; i < getProbsForState(state).length; i++) {
            prob += getProbsForState(state)[i];
            if (probability <= prob) {
                return StochasticState.indexToEnum(i);
            }
        }
        throw new RuntimeException("this really should not happen");
    }

    private double[] getProbsForState(StochasticState state) {
        return probabilities[state.getIndex()];
    }

    public void randomWalk() {
        this.state = getStateForProbability(random.nextDouble());
    }

    public StochasticState getState() {
        return state;
    }
}
