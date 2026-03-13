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
    }
}
