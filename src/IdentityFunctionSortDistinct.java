import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IdentityFunctionSortDistinct {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList(
                "C", "C#", "Python", "C", "PHP", "Java", "Python", "JavaScript", "C#", "Java"
        );
        // Group tags by their identity and count occurrences
        Map<String, Long> languageCount = languages.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(languageCount);
        System.out.println("Remove duplicates using distinct");
        languages.stream().distinct().forEach(System.out::println);
        System.out.println("Remove duplicates using Set");
        languages.stream().collect(Collectors.toSet()).forEach(System.out::println);
        //Remove duplicates and sort list in natural order
        List<String> l = languages.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println(l);
        //Remove duplicates and sort in reverse order
        List<String> r = languages.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(r);
        //Remove duplicates and sort each String by it's last character
        List<String> s = languages.stream().distinct().sorted(Comparator.comparing(s1 -> s1.charAt(s1.length() - 1))).collect(Collectors.toList());
        System.out.println(s);
        List<String> t = languages.stream().distinct().sorted((var x, var y) -> Character.compare(x.charAt(x.length() - 1), y.charAt(y.length() - 1))).collect(Collectors.toList());
        System.out.println(t);
    }

}
