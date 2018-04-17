package shop;

public enum StochasticState {
    FIRST(0),SECOND(1),THIRD(2),FOURTH(3);

    private int index;

    StochasticState(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    public static StochasticState indexToEnum(int index) {
        for (StochasticState stochasticState : StochasticState.values()) {
            if (index == stochasticState.index) {
                return stochasticState;
            }
        }
        throw new RuntimeException();
    }
}
