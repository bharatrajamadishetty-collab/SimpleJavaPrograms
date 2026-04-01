import java.util.Arrays;

public class RemoveNaNPrintIntegerArray {
    static Integer[] numbersOnly(String[] d) {
        Integer[] i = new Integer[d.length];
        int j = 0;
        for (String x : d) {
            try {
                if (!Double.isNaN((Double.parseDouble(x)))) {
                    i[j++] = Integer.parseInt(x);
                }
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    static Integer[] numbersOnlyWithStreams(String[] d) {
        return Arrays.stream(d).filter(y -> {
            try {
                return !Double.isNaN((Double.parseDouble(y)));
            } catch (NumberFormatException e) {
                return false;
            }
        }).map(Integer::parseInt).toArray(Integer[]::new);
    }

    static void numbersOnlyWithStreamsForEach(String[] t) {
        Arrays.stream(t).forEach(y -> {
            try {
                if (!Double.isNaN((Double.parseDouble(y)))) {
                    System.out.print(y + " ");
                }
            } catch (NumberFormatException e) {
            }
        });
    }

    public static void main(String[] args) {
        String[] s = { "193", "as", "380", "413", "9ra", "www", "-52", "NaN", "0" };
        System.out.println("Integer array after removing NaN values = " + Arrays.toString(numbersOnly(s)));
        System.out.println("Integer array after removing NaN values = " + Arrays.toString(numbersOnlyWithStreams(s)));
        numbersOnlyWithStreamsForEach(s);
    }
}
