interface Calculator<T> {
    T calculate(T a, T b);
}

public enum GenericCalculator  implements Calculator<Double> {
    ADD {
        @Override
        public Double calculate(Double a, Double b) {
            return a + b;
        }
    },
    SUBTRACT {
        @Override
        public Double calculate(Double a, Double b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        public Double calculate(Double a, Double b) {
            return a * b;
        }
    },
    DIVIDE {
        @Override
        public Double calculate(Double a, Double b) {
            return a / b;
        }
    },
    PERCENTAGE {
        @Override
        public Double calculate(Double a, Double b) {
            return a % b;
        }
    };

    public static void main(String[] args) {
        System.out.println(ADD.calculate(10.7, 15.4));
        System.out.println(SUBTRACT.calculate(108.3, 45.9));
        System.out.println(MULTIPLY.calculate(51.5, 24.2));
        System.out.println(DIVIDE.calculate(39.5, 14.0));
        System.out.println(PERCENTAGE.calculate(105.0, 36.0));

        System.out.println("---------Using Lambda Expressions------------");
        Calculator<Double> add = (Double x, Double y) -> x + y;
        Calculator<Double> sub = (Double x, Double y) -> x - y;
        Calculator<Double> div = (Double x, Double y) -> x / y;
        Calculator<Double> mul = (Double x, Double y) -> x * y;
        Calculator<Double> percent = (Double x, Double y) -> x % y;
        System.out.println(add.calculate(47.21, 35.73));
        System.out.println(div.calculate(21.21, 3.33));
        System.out.println(mul.calculate(73.34, 35.68));
        System.out.println(percent.calculate(135.41, 53.82));
        System.out.println(sub.calculate(91.15, 68.35));
        
    }
}
