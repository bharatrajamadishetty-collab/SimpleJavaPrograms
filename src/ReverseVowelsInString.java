import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseVowelsInString {
    public static String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!isVowel(c[i])) {
                i++;
                continue;
            }
            if (!isVowel(c[j])) {
                j--;
                continue;
            }
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        return new String(c);
    }

    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        String s = "delicious";
        System.out.println(reverseVowels(s));

        // Alternative approach using streams
        List<Character> vowels = s.chars().mapToObj(i -> (char) i).filter(i -> isVowel((char) i)).collect(Collectors.toList());
        Collections.reverse(vowels);
        int[] index = {0};
        IntStream.range(0, s.length()).mapToObj(i -> {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                return vowels.get(index[0]++);
            } else {
                return ch;
            }
        }).forEach(System.out::print);
    }

}
