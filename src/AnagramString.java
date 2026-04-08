import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramString {
    // using streams
    static boolean anagram(String e, String f) {
        String g = Stream.of(e.toLowerCase().split("\\s*")).sorted().collect(Collectors.joining(""));
        String h = Stream.of(f.toLowerCase().split("\\s*")).sorted().collect(Collectors.joining(""));
        return g.equals(h);
    }

    public static void main(String[] args) {
        String a = "Mother   In Law ";
        String b = "    Hitler      Woman";
        a = a.toLowerCase();
        b = b.toLowerCase();
        // remove white spaces and tab spaces from string
        a = a.replaceAll("\\s*", "");
        b = b.replaceAll("\\s*", "");
        char[] c = a.toCharArray();
        char[] d = b.toCharArray();
        Arrays.sort(c);
        Arrays.sort(d);
        if (Arrays.equals(c, d) && anagram(a, b)) {
            System.out.println("The strings " + a + " and " + b + " are anagrams");
        } else {
            System.out.println("The strings " + a + " and " + b + " are not anagrams");
        }
    }

}
