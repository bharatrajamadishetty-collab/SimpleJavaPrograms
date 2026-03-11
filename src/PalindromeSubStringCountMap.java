import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromeSubStringCountMap {

    public static boolean palindromeCheck(String t) {
        StringBuilder sb = new StringBuilder();
        sb.append(t);
        sb.reverse();
        if(t.equals(sb.toString())) {
            return true;
        }
        return false;
    }
    public static void main(String []args) {
        Map<String, Integer> m = new HashMap<>();
        String a = "";
        String s = "Besties forever are always together";
        s = s.replace(" ","");
        List<Integer> len = new ArrayList<>();
        boolean ispalindrome = false;
        char[] c = s.toCharArray();
        for(int i=0; i<s.length()-1; i++) {
            for(int j=i+1; j<s.length(); j++) {
                a = s.substring(i,j+1);
                ispalindrome = palindromeCheck(a);
                if(ispalindrome) {
                    m.put(a,a.length());
                    System.out.println("subString "+ a +" is a palindrome");
                    len.add(a.length());
                }
            }
        }
        Collections.sort(len, Collections.reverseOrder());
        for(Map.Entry e : m.entrySet()) {
            if(e.getValue() == len.get(2)) {
                System.out.println(" Second highest length palindrome substring is: "+e.getKey());
            }
        }
        System.out.println("\n"+"palindrome substrings: "+m);
    }

}
