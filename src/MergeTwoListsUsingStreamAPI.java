
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MergeTwoListsUsingStreamAPI {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> b = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> c = Stream.concat(a.stream(), b.stream()).toList();
        System.out.println(c);

        List<String> d = Arrays.asList("a", "b");
        List<Character> e = Arrays.asList('c', 'd');
        Stream.concat(d.stream(), e.stream()).forEach(System.out::println);

        List<Double> f = Arrays.asList(11.8, 34.6, 5.3, 27.9, 89.1);
        List<String> g = Arrays.asList("ant", "rob", "dust");
        Stream.concat(f.stream(), g.stream()).forEach(System.out::println);

        Stream.builder().add(d).add(g).add(e).add(f).add(74).add("Surprise").build().forEach(System.out::println);
        Stream.builder().add("Software").add("Engineer").build().sorted().forEach(System.out::println);

        Stream.of(35.32, 49.91, 93.18).iterator().forEachRemaining(System.out::println);

        List<Double> l = Stream.generate(Math::random).limit(4).sorted(Comparator.reverseOrder()).toList();
        System.out.println(l);

    }

}
