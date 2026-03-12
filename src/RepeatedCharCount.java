import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatedCharCount {
public static void main(String []args) {
        String s = " Don  Bradman ";
        s = s.replaceAll("\\s*","");
        s = s.toLowerCase();
        Map<Character,Long> m = s.chars().mapToObj(c -> (char)c).sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Each character count map = "+m);
        for(Map.Entry<Character,Long> e : m.entrySet()){
            if(e.getValue().equals((long)1)){
                System.out.println("First non repeating character = "+e.getKey());
                break;
            }
        }
    }
}
