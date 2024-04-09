package item;

public enum ItemType {
    OREO("OREO"),
    JUICE("JUICE"),
    COKE("COKE"),
    SODA("SODA"),
    CHIPS("CHIPS"),
    CHOCOLATE("CHOCOLATE"),
    CANDY("CANDY"),
    GUM("GUM");

    private final String value;

    private ItemType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
