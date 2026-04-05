import java.util.Arrays;
import java.util.List;

public class FirstSequenceCharInString {
    // using streams
    static String longestCommonPrefix(List<String> a) {
        return a.stream().reduce((s1, s2) -> {
            int i = 0;
            while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
                i++;
            }
            return s1.substring(0, i);
        }).orElse("");
    }

    public static void main(String[] args) {
        List<String> sl = Arrays.asList("flow", "flower", "flight", "flute", "flex");
        System.out.println("Result substring = " + longestCommonPrefix(sl));
        String t = sl.get(0);
        String g;
        String r = null;
        for (int i = 0; i < t.length(); i++) {
            g = t.substring(0, i + 1);
            int c = 0;
            for (String s : sl) {
                if (g.length() < s.length() && g.equals(s.substring(0, i + 1))) {
                    c++;
                } else {
                    break;
                }
            }
            if (c == sl.size()) {
                r = g;
            }
        }
        System.out.println("Result substring = " + r);
    }

}
