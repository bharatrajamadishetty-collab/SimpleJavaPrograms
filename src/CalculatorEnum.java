public enum CalculatorEnum {
    ADD, SUBTRACT, MULTIPLY, DIVIDE;

    public <T extends Number> double apply(T a, T b) {
        switch (this) {
            case ADD:
                return a.doubleValue() + b.doubleValue();
            case SUBTRACT:
                return a.doubleValue() - b.doubleValue();
            case MULTIPLY:
                return a.doubleValue() * b.doubleValue();
            case DIVIDE:
                return a.doubleValue() / b.doubleValue();
            default:
                throw new AssertionError("Unknown operation: " + this);
        }
    }

    public static void main(String[] args) {
        System.out.println(DIVIDE.apply(75, 5));
        System.out.println(ADD.apply(10, 20));
        System.out.println(MULTIPLY.apply(5.5, 4));
        System.out.println(SUBTRACT.apply(39.5, 14));
    }

}
