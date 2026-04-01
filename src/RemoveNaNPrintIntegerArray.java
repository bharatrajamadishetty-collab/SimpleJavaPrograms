import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class RemoveNaNPrintIntegerArray {
    static List<Integer> numbersOnly(String[] a) {
        List<Integer> l = new ArrayList<>();
        for (String x : a) {
            try {
                if (x != null && !Double.isNaN((Double.parseDouble(x)))) {
                    l.add(Integer.parseInt(x));
                }
            } catch (NumberFormatException e) {
            }
        }
        return l;
    }

    static List<Integer> integersOnly(String[] b) {
        List<Integer> i = new ArrayList<>();
        for (String x : b) {
            try {
                i.add(Integer.parseInt(x));
            } catch (NullPointerException | NumberFormatException e) {
            }
        }
        return i;
    }

    static List<Integer> integersOnlyUsingMatchers(String[] c) {
        List<Integer> k = new ArrayList<>();
        for (String x : c) {
            try {
                if (x != null && x.matches("-?\\d+")) {
                    k.add(Integer.valueOf(x));
                }
            } catch (NumberFormatException ex) {
            }
        }
        return k;
    }

    static Integer[] numbersOnlyWithStreams(String[] d) {
        return Arrays.stream(d).filter(y -> {
            try {
                return y != null && !Double.isNaN((Double.parseDouble(y)));
            } catch (NumberFormatException e) {
                return false;
            }
        }).map(Integer::parseInt).toArray(Integer[]::new);
    }

    static List<Integer> numbersOnlyWithStreamsForEach(String[] t) {
        List<Integer> j = new ArrayList<>();
        Stream.of(t).forEach(y -> {
            try {
                j.add(Integer.parseInt(y));
            } catch (NullPointerException | NumberFormatException e) {
            }
        });
        return j;
    }

    static List<Integer> numberOnlyUsingMatchers(String[] f) {
        List<Integer> q = new ArrayList<>();
        Stream.of(f).forEach(g -> {
            try {
                if (g != null && g.matches("-?\\d+")) {
                    q.add(Integer.valueOf(g));
                }
            } catch (NumberFormatException e) {
            }
        });
        return q;
    }

    public static void main(String[] args) {
        String[] s = { "193", "as", "380", "413", "9ra", "www", "-52", "NaN", null, "null", "0" };
        System.out.println("Integer array after removing NaN values = " + numbersOnly(s));
        System.out.println("Integer array after removing NaN values = " + integersOnly(s));
        System.out.println("Integer array after removing NaN values = " + Arrays.toString(numbersOnlyWithStreams(s)));
        System.out.println("Integer array after removing NaN values = " + numbersOnlyWithStreamsForEach(s));
        System.out.println("Integer array after removing NaN values = " + numberOnlyUsingMatchers(s));
    }
}
