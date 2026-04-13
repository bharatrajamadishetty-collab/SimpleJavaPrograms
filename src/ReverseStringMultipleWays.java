
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ReverseStringMultipleWays {
    static String reverseSwapString(String a) {
        char[] c = a.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
        }
        return new String(c);
    }

    static String reverseString(String d) {
        for (int k = 0; k < d.length() / 2; k++) {
            char t = d.charAt(k);
            d = d.substring(0, k) + d.charAt(d.length() - 1 - k)
                    + d.substring(k + 1, d.length() - 1 - k) + t + d.substring(d.length() - k);
        }
        return d;
    }

    static String reverseStringBuilder(String b) {
        StringBuilder sb = new StringBuilder();
        sb.append(b);
        sb.reverse();
        return sb.toString();
    }

    // using IntStream.range() and mapToObj()
    static String reversewithIntStream(String h) {
        return IntStream.range(0, h.length()).mapToObj(p -> h.charAt(h.length() - 1 - p))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }

    static String reverseIntStream(String t) {
        return IntStream.range(0, t.length()).mapToObj(q -> String.valueOf(t.charAt(t.length() - 1 - q)))
                .collect(Collectors.joining(""));
    }

    // using chars()
    static String reversewithCharsStreamMap(String f) {
        return f.chars().mapToObj(m -> String.valueOf((char) m)).reduce((u, v) -> v + u).get();
    }

    // reverse using reduce()
    static String reduceToReverseString(String t) {
        return Stream.of(t.split("")).reduce((i, j) -> j + i).get();
    }

    public static void main(String args[]) {
        String s = "pipeline";
        System.out.println("reversed string = " + reverseSwapString(s));
        System.out.println("reversed string = " + reverseStringBuilder(s));
        System.out.println("reversed string = " + reversewithIntStream(s));
        System.out.println("reversed string = " + reversewithCharsStreamMap(s));
        System.out.println("reversed string = " + reverseString("pipeline"));
        System.out.println("reversed string = " + reduceToReverseString("pipeline"));
        System.out.println("reversed string = " + reverseIntStream("pipeline"));
    }
}
