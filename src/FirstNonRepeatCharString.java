import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRepeatCharString {

    static String firstNonRepeatCharUsingStreams(String s) {
        return Stream.of(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(f -> f.getValue() == 1).findFirst().map(Map.Entry::getKey).get();
    }

    public static void main(String[] args) {
        String s = "abcdcbbace";
        char[] c = s.toCharArray();
        int d;
        Map<Character, Integer> a = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!a.containsKey(c[i])) {
                a.put(c[i], 1);
            } else {
                d = a.get(c[i]);
                a.put(c[i], d + 1);
            }
        }
        for (Map.Entry<Character, Integer> m : a.entrySet()) {
            if (m.getValue().equals(1)) {
                System.out.println("First Non repeating character is: " + m.getKey());
                break;
            }
        }

        System.out.println("First non repeating character using streams is: " + firstNonRepeatCharUsingStreams(s));
    }

}
