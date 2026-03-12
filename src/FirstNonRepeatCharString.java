import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatCharString {
    public static void main(String []args) {
        String s = "abcdcbbace";
        char[] c = s.toCharArray();
        int d=0;
        Map<Character,Integer> a = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(!a.containsKey(c[i])) {
                a.put(c[i],1);
            } else {
                d = a.get(c[i]);
                a.put(c[i],d+1);
            }
        }
        for(Map.Entry<Character,Integer> m : a.entrySet()) {
            if(m.getValue().equals(1)) {
                System.out.println("Non repeating character is: "+m.getKey());
                break;
            }
        }
    }

}
