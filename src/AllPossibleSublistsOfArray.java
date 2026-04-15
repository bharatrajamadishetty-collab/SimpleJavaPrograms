
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class AllPossibleSublistsOfArray {
    static List<List<Integer>> subLists(int[] b) {
        return IntStream.range(0, 1 << b.length)
                .mapToObj(i -> IntStream.range(0, b.length)
                        .filter(j -> (i & (1 << j)) != 0)
                        .mapToObj(j -> b[j])
                        .toList())
                .toList();
    }

    static List<int[]> allSubLists(int[] c) {
        return IntStream.rangeClosed(1, c.length).boxed().flatMap(window -> IntStream
                .range(0, c.length - (window - 1)).mapToObj(p -> Arrays.copyOfRange(c, p, p + window))).toList();
    }

    public static void main(String[] args) {
        int[] a = { 2, 1, 0, 9, 5 };
        System.out.println(subLists(a));

        List<int[]> l = allSubLists(a);
        l.forEach(x -> System.out.println(Arrays.toString(x)));
    }
}
