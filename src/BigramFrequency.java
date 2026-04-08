import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BigramFrequency {
    public static void main(String[] args) {
        String paragraph = "Java is great and Java is fun. Java is powerful!";

        String[] words = paragraph.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+");

        List<String> list = IntStream.range(0, words.length - 1)
                .mapToObj(i -> words[i] + " " + words[i + 1]).toList();
        System.out.println(list);

        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

}
