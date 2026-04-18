
public class SubStringMatchOperations {
    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        int a = s.length(), b = t.length(), c = 0;
        if (a == b && s.equals(t)) {
            return "Yes";
        } else {
            for (int i = 0; i < b; i++) {
                if (i == b - 1) {
                    s = s.substring(i + 1, a);
                    c = s.length();
                    break;
                } else if (s.charAt(i) != t.charAt(i)) {
                    s = s.substring(i, a);
                    t = t.substring(i, b);
                    c = s.length() + t.length();
                    break;
                }

            }
            System.out.println(c);
        }
        if (c > k) {
            return "No";
        }
        return "Yes";
    }

    public static void main(String[] args) {
        System.out.println(appendAndDelete("aba", "aba", 4));
        System.out.println(appendAndDelete("hackerhappy", "hackerrank", 9));
        System.out.println(appendAndDelete("ashley", "ash", 2));
    }
}
