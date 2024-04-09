package coin;

public enum Coin {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    FIFTY(50),
    HUNDERED(100);

    private final int value;

    private Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
