import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class NumberSequenceList {
    static void numberSequenceUsingStreams(Integer[] a) {
        List<Set<Integer>> result = new ArrayList<>();
        Set<Integer> current = new LinkedHashSet<>();
        IntStream.range(1, a.length)
                .forEach(i -> {
                    if (a[i] == a[i - 1] + 1) {
                        current.add(a[i - 1]);
                        current.add(a[i]);

                        if (a[i].equals(a[a.length - 1])) {
                            result.add(current);
                        }
                    } else {
                        if (!current.isEmpty()) {
                            result.add(new LinkedHashSet<>(current));
                        }
                        current.clear();
                    }
                });
        System.out.println(result);
    }

    public static void main(String[] args) {
        Integer[] a = { 1, 5, 6, 9, 3, 4, 5, 1, 14, 15, 16, 17, 18 };
        numberSequenceUsingStreams(a);

        List<Set<Integer>> result = new ArrayList<>();
        Set<Integer> current = new LinkedHashSet<>();
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1] + 1) {
                current.add(a[i - 1]);
                current.add(a[i]);

                if (a[i].equals(a[a.length - 1])) {
                    result.add(current);
                }
            } else {
                if (!current.isEmpty()) {
                    result.add(new LinkedHashSet<>(current));
                }
                current.clear();
            }
        }
        System.out.println(result);

    }

}