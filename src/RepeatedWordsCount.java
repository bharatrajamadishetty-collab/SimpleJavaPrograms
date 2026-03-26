
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RepeatedWordsCount {
    public static void main(String args[]){
        String s = "Car mileage is imp. A car with good mileage is preferred. Many people buy car based on mileage.";
        s = s.replaceAll("\\.", "");
        s = s.toLowerCase();
        String [] words = s.split("\\s+");
        Map<String,Integer> m = new HashMap<>();
        Integer c;
        for(String w : words){
            if(w.equals("car")){
                c = m.get("car");
                m.put(w, c == null ? 1 : ++c);
            }
            if (w.equals("mileage")) {
                c = m.get("mileage");
                m.put(w, c == null ? 1 : ++c);
            }
        }
        System.out.println(m);

        //Using streams groupingby Identity Function and Counting
        Map<String, Long> ms = Stream.of(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        .limit(2).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(ms);
    }

}
