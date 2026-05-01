
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class KRepeatedNumbersList {
    static void printKRepeatedNumbers(List<Integer> list, int k) {
        Set<Integer> set = new HashSet<>();
        IntStream.range(1, list.size())
                .filter(i -> list.get(i).equals(list.get(i - 1)))
                .forEach(i -> {
                    int count = 1;
                    while (i < list.size() && list.get(i).equals(list.get(i - 1))) {
                        count++;
                        i++;
                    }
                    if (count >= k) {
                        set.add(list.get(i - 1));
                    }
                });
        System.out.println("Numbers that are repeated at least " + k + " times: " + set);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 1, 1, 2, 2, 3);
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
    }

}
