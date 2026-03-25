import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Using Unnamed Class
public static void main(String []args) {
        String s = " Don  Bradman ";
        s = s.replaceAll("\\s*","");
        s = s.toLowerCase();
        Map<Character,Long> m = s.chars().mapToObj(c -> (char)c).sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Each character frequency count map = "+m);
        for(Map.Entry<Character,Long> e : m.entrySet()){
            if(e.getValue().equals((long)1)){
                System.out.println("First non repeating character = "+e.getKey());
                break;
            }
        }

        System.out.println("All characters and their frequency count pairs = ");
        s.chars().mapToObj(c -> (char)c).sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().forEach(System.out::println);
        System.out.println("Repeated characters and their frequency count pairs = ");
        s.chars().mapToObj(c -> (char)c).sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().forEach(f -> {
           if(f.getValue()>(long)1){
                System.out.println(f.getKey()+":"+f.getValue());
            } 
        });
    }
