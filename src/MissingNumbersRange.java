
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNumbersRange {

    public static void main(String[] args) {
        int[] k = { 1, 1, 2, 6, 9, 9, 6, 2, 1 };
        int min = Arrays.stream(k).min().getAsInt();
        int max = Arrays.stream(k).max().getAsInt();
        Set<Integer> numbers = Arrays.stream(k).boxed().collect(Collectors.toSet());
        System.out.println("printing all missing numbers in the array: ");
        IntStream.rangeClosed(min, max).boxed().filter(x -> !numbers.contains(x))
                .forEach(System.out::println);
    }

}
