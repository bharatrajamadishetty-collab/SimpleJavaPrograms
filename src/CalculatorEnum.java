
import java.util.Scanner;

public enum CalculatorEnum {
    ADD, SUBTRACT, MULTIPLY, DIVIDE;

    public <T extends Number> double apply(T a, T b) {
        return switch (this) {
            case ADD ->
                a.doubleValue() + b.doubleValue();
            case SUBTRACT ->
                a.doubleValue() - b.doubleValue();
            case MULTIPLY ->
                a.equals(0) || b.equals(0)? 0 : a.doubleValue() * b.doubleValue();
            case DIVIDE ->
                a.equals(0) && b.equals(0)? 0 : a.doubleValue() / b.doubleValue();
            default ->
                throw new AssertionError("Unknown operation: " + this);
        };
    }

    public static void main(String[] args) {
        System.out.println("Enter 2 double values to calculate : ");
        try (Scanner sc = new Scanner(System.in)) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            System.out.println(DIVIDE.apply(x, y));
            System.out.println(ADD.apply(x, y));
            System.out.println(MULTIPLY.apply(x, y));
            System.out.println(SUBTRACT.apply(x, y));
        }
    }

}
