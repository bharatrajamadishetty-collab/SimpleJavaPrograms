import java.util.Arrays;
import java.util.List;

public class FirstSequenceCharInString {
    public static void main(String []args) {
        List<String> sl = Arrays.asList("flow", "flower", "flight", "flute", "flex");
        String t = sl.get(0);
        String g;
        String r = null;
        for(int i=0; i<t.length(); i++) {
            g = t.substring(0, i+1);
            int c = 0;
            for(String s : sl) {
                if(g.length() < s.length() && g.equals(s.substring(0, i+1))) {
                    c++;
                } else {
                    break;
                }
            }
            if(c == sl.size()) {
                r =  g;
            }
        }
        System.out.println("Result substring = "+r);
    }

}
