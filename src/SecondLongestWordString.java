import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class SecondLongestWordString {
    public static void main(String[] args) {
        String s = "I am a software developer.";
        Optional<String> secondLargest = Arrays.stream(s.replaceAll("[^a-zA-Z\\s]", "").split("\\s+"))
                .sorted(Comparator.comparingInt(String::length).reversed()).skip(1).findFirst();

        Optional<Integer> first = Arrays.stream(s.split("[^a-zA-Z\\\\s]")).map(i -> i.length())
                .sorted(Comparator.reverseOrder()).skip(1).findFirst();

        Optional<Integer> max = Arrays.stream(s.split("[^a-zA-Z\\\\s]")).map(i -> i.length())
                .max(Comparator.naturalOrder());

        max.ifPresent(length -> System.out.println("Length of largest word: " + length));

        first.ifPresent(length -> System.out.println("Length of second largest word: " + length));

        secondLargest.ifPresent(word -> System.out.println("Second Largest word: " + word));
    }

}
