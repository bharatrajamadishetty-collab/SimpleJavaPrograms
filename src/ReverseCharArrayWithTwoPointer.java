
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReverseCharArrayWithTwoPointer {
    static char[] reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        return s;
    }

    static char[] reverseChars(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char t = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = t;
        }
        return s;
    }

    static char[] reverseCharRead(char[] s) {
        char[] r = new char[s.length];
        for (int i = 0; i < s.length; i++) {
            r[i] = s[s.length - 1 - i];
        }
        return r;
    }

    static char[] reverseArrayWithRecursion(char[] a, int i, int j) {
        if (i < j) {
            return a;
        }
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return reverseArrayWithRecursion(a, i + 1, j - 1);
    }

    static char[] reverseArrayWithStringBuilder(char[] b) {
        StringBuilder sb = new StringBuilder();
        sb.append(b);
        sb.reverse();
        return sb.toString().toCharArray();
    }

    static char[] reverseArrayUsingStreamsForEach(char[] d) {
        IntStream.range(0, d.length / 2).forEach(y -> {
            char t = d[y];
            d[y] = d[d.length - 1 - y];
            d[d.length - 1 - y] = t;
        });
        return d;
    }

    static List<Character> reversewithStreamMap(char[] arr) {
        return IntStream.range(0, arr.length).mapToObj(i -> arr[arr.length - 1 - i]).toList();
    }

    static List<Character> reverseWithStreamForEach(char[] arr) {
        List<Character> l = new ArrayList<>();
        IntStream.range(0, arr.length).forEach(i -> {
            l.add(arr[arr.length - 1 - i]);
        });
        return l;
    }

    static char[] reverseArrayUsingStreamsMap(char[] e) {
        return IntStream.range(0, e.length).mapToObj(m -> e[e.length - 1 - m])
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString().toCharArray();
    }

    public static void main(String[] args) {
        char[] c = { 'h', 'e', 'l', 'l', 'o' };
        System.out.println("Reversed char array = " + Arrays.toString(reverseArrayWithStringBuilder(c)));
        System.out.println("Reversed char array = " + Arrays.toString(reverseString(c)));
        char[] d = { 'h', 'e', 'l', 'l', 'o' };
        System.out.println("Reversed char array = " + Arrays.toString(reverseChars(d)));
        System.out.println("Reversed char array = " + Arrays.toString(reverseArrayWithRecursion(c, 0, c.length - 1)));
        char[] f = { 'h', 'e', 'l', 'l', 'o' };
        System.out.println("Reversed char array = " + Arrays.toString(reverseArrayUsingStreamsForEach(f)));
        char[] g = { 'h', 'e', 'l', 'l', 'o' };
        System.out.println("Reversed char array = " + Arrays.toString(reverseArrayUsingStreamsMap(g)));
        System.out.println("Reversed char array = " + reversewithStreamMap(g));
        System.out.println("Reversed char array = " + reverseWithStreamForEach(g));
        System.out.println("Reversed char array = " + Arrays.toString(reverseCharRead(g)));
    }
}
