
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MissingNumbersRange {

    public static void main(String[] args) {
        int[] k = { 1, 1, 2, 6, 9, 9, 6, 2, 1 };
        int min = Arrays.stream(k).min().getAsInt();
        int max = Arrays.stream(k).max().getAsInt();
        Set<Integer> numbers = Arrays.stream(k).boxed().collect(Collectors.toSet());
        System.out.println("printing all missing numbers in the array: ");
        IntStream.rangeClosed(min, max).boxed().filter(x -> !numbers.contains(x))
                .forEach(System.out::println);

        List<Integer> l = Arrays.asList(1, 2, 6, 9, 1);
        min = l.stream().mapToInt(i -> i).min().getAsInt();
        System.out.println("Min = " + min);
        max = l.stream().max(Integer::compare).get();
        System.out.println("Max = " + max);
        List<Integer> d = l.stream().distinct().toList();
        IntStream.rangeClosed(min, max).filter(x -> !d.contains(x))
                .forEach(System.out::println);

        // Generate an infinite stream of random numbers and limit it to 5 elements
        Stream<Double> limit = Stream.generate(Math::random).limit(5);
        System.out.println("Ramdom numbers : " + limit.toList());
    }

}
