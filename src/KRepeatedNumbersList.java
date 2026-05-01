
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KRepeatedNumbersList {
    static void kFrequencyUsingStreamWithMap(List<Integer> l, int k) {
        Map<Integer, Long> m = l.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> t = m.entrySet().stream().filter(e -> e.getValue() >= k).map(e -> e.getKey()).toList();
        System.out.println("Numbers that are repeated at least " + k + " times: " + t);
        // Alternative way to print the numbers that are repeated at least k times
        for (Map.Entry<Integer, Long> e : m.entrySet()) {
            if (e.getValue() >= k) {
                System.out.println(e.getKey());
            }
        }
    }

    static void kFrequencyUsingStream(List<Integer> l, int k) {
        Set<Integer> set = new HashSet<>();
        l.stream().filter(i -> l.stream().filter(j -> j.equals(i)).count() >= k).forEach(set::add);
        System.out.println("Numbers that are repeated at least " + k + " times: " + set);
    }

    static void printKRepeatedNumbers(List<Integer> list, int k) {
        Set<Integer> set = new HashSet<>();
        IntStream.range(1, list.size())
                .filter(i -> list.get(i).equals(list.get(i - 1)))
                .forEach(i -> {
                    int count = 1;
                    if (list.get(i).equals(list.get(i - 1))) {
                        count++;
                    }
                    if (count >= k) {
                        set.add(list.get(i));
                    }
                });
        System.out.println("Numbers that are repeated at least " + k + " times: " + set);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 1, 1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9);
        Set<Integer> set = new HashSet<>();
        int k = 2;
        for (int i = 1; i < list.size(); i++) {
            int count = 1;
            if (list.get(i).equals(list.get(i - 1))) {
                count++;
            }
            if (count >= k) {
                set.add(list.get(i));
            }
        }
        System.out.println("Numbers that are repeated at least " + k + " times: " + set);
        printKRepeatedNumbers(list, k);
        kFrequencyUsingStream(list, k);
        kFrequencyUsingStreamWithMap(list, k);
    }

}
