
import java.util.Arrays;
import java.util.stream.IntStream;

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

    static void reverseArrayUsingStreamsForEach(char[] d) {
        IntStream.range(0, d.length / 2).forEach(y -> {
            char t = d[y];
            d[y] = d[d.length - 1 - y];
            d[d.length - 1 - y] = t;
        });
        System.out.println("Reversed char array = " + Arrays.toString(d));
    }

    static char[] reverseArrayUsingStreamsMap(char[] e) {
        return IntStream.range(0, e.length).mapToObj(m -> (char) e[e.length - 1 - m])
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString().toCharArray();
    }

    public static void main(String[] args) {
        char[] c = { 'h', 'e', 'l', 'l', 'o' };
        System.out.println("Reversed char array = " + Arrays.toString(reverseArrayWithStringBuilder(c)));
        System.out.println("Reversed char array = " + Arrays.toString(reverseString(c)));
        System.out.println("Reversed char array = " + Arrays.toString(reverseArrayWithRecursion(c, 0, c.length - 1)));
        char[] f = { 'h', 'e', 'l', 'l', 'o' };
        reverseArrayUsingStreamsForEach(f);
        char[] g = { 'h', 'e', 'l', 'l', 'o' };
        System.out.println("Reversed char array = " + Arrays.toString(reverseArrayUsingStreamsMap(g)));
    }
}
