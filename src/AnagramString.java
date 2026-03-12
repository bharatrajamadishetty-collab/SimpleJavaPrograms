import java.util.Arrays;

public class AnagramString {
    public static void main(String []args) {
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
        if (Arrays.equals(c, d)) {
            System.out.println("The strings \"" + a + "\" and \"" + b + "\" are anagrams");
        } else {
            System.out.println("The strings \"" + a + "\" and \"" + b + "\" are not anagrams");
        }
    }

}
