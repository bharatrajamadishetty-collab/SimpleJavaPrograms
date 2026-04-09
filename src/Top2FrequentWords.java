import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Top2FrequentWords {
    public static void main(String[] args) {
        String s = "Java is great great is. Java is object oriented. Java streams are powerful, and Java is fun!";

        List<Map.Entry<String, Long>> map = Arrays.stream(s.replaceAll("[^a-zA-Z\\s]", "").split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .toList();

        List<Long> topFrequency = map.stream()
                .map(Map.Entry::getValue)
                .distinct()
                .limit(2)
                .toList();
        System.out.println(topFrequency);

        List<Map.Entry<String, Long>> list = map.stream()
                .filter(e -> topFrequency.contains(e.getValue()))
                .toList();
        System.out.println(list);

    }

}
