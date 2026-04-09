
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReverseEachWordInString {

    static String reverseStringBuilder(String x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.reverse();
        return sb.toString();
    }

    static String reverseStringBuffer(String y) {
        StringBuffer sb = new StringBuffer(y);
        sb.reverse();
        return sb.toString();
    }

    static StringBuilder reverseString(String z) {
        return IntStream.range(0, z.length()).mapToObj(m -> (char) z.charAt(z.length() - 1 - m))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
    }

    static String reverseEachWord(String t) {
        return Stream.of(t.split("\\s+")).map(w -> Stream.of(w.split("")).reduce("", (i, j) -> j + i))
                .collect(Collectors.joining(" "));
    }

    static String reverseEachWordAndChars(String t) {
        return Stream.of(t.split("\\s+")).map(w -> Stream.of(w.split("")).reduce("", (i, j) -> j + i))
                .reduce("", (k, l) -> l + " " + k);
    }

    public static void main(String[] args) {
        String s = "best friends  forever";
        StringBuilder w = new StringBuilder();
        StringBuilder sl = new StringBuilder();
        StringBuffer sb = new StringBuffer();
        String[] a = s.split("\\s+");
        for (String t : a) {
            // using StringBuilder
            sl.append(reverseStringBuilder(t)).append(" ");
            // using StringBuffer
            sb.append(reverseStringBuffer(t)).append(" ");

            w.append(reverseString(t)).append(" ");
        }
        System.out.println("Reversing each word in the string = " + sl.toString());
        System.out.println("Reversing each word in the string = " + sb.toString());
        System.out.println("Reversing each word in the string = " + w.toString());
        System.out.println("Reversing each word in the string = " + reverseEachWord(s));
        System.out.println("Reversing each word in the string = " + reverseEachWordAndChars(s));
    }

}
