import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FindIndexUsingIntStream {
    public static void main(String []args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the value to search for = ");
            int t = sc.nextInt();
            List<Integer> l = List.of(5,7,7,8,8,8,8,10);
            int fI = IntStream.range(0,l.size()).filter(i -> Objects.equals(l.get(i), t)).findFirst().orElse(-1);
            int lI = IntStream.range(0,l.size()).filter(i -> Objects.equals(l.get(i), t)).reduce((j,k) -> k).orElse(-1);
            System.out.println("Occurance of First and Last Index of " + t + ": ["+fI+","+lI+"]");

            //Alternative approach using forEach
            l.forEach(i -> {
                if (Objects.equals(i, t)) {
                    System.out.println(l.indexOf(i)+","+l.lastIndexOf(i));
                }
            });
        }
    }
    
}
