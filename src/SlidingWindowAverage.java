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
    }

}
