import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SlidingWindowAverage {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(4, 8, 15, 16, 23, 42);
        int window = 3; // 4+8+15/3 = 9 , 8+15+16/3 = 13 , 15+16+23/3 = 18 , 16+23+42/3 = 27
        List<Double> average = IntStream.range(0, l.size() - (window - 1))
                .mapToObj(i -> l.subList(i, window + i))
                .map(m -> m.stream().mapToInt(Integer::intValue).average().getAsDouble()).toList();
        System.out.println(average);

        List<Integer> h = Arrays.asList(2, -2, 6, -9, 9, 1, -1);
        int w = 2;
        List<Integer> sum = IntStream.range(0, h.size() - (w - 1))
                .mapToObj(j -> h.subList(j, w + j))
                .map(m -> m.stream().mapToInt(x -> x).sum()).filter(x -> x != 0).toList();
        System.out.println("Non zero sums of sublists : " + sum);

        List<List<Integer>> a = IntStream.range(0, h.size() - (w - 1))
                .mapToObj(k -> h.subList(k, w + k)).filter(f -> f.stream().mapToInt(p -> p).sum() != 0).toList();
        System.out.println("List of Sublists with non zero sum : " + a);

    }

}
