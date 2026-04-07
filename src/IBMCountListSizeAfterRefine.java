
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IBMCountListSizeAfterRefine {
    static List<Integer> refineData(List<Integer> a) {
        List<Integer> c = new ArrayList<>();
        while (!a.isEmpty()) {
            c.add(a.size());
            int min = a.stream().min(Integer::compare).get();
            a.removeIf(i -> i == min || i == 0);
            a.replaceAll(j -> j > min ? j - min : 0);
        }
        return c;
    }

    public static void main(String[] args) {
        int[] p = { 1, 1, 4, 3 }; // [3,2] -> [1] -> [] -> list size in each iteration = [4,2,1]
        List<Integer> l = Arrays.stream(p).boxed().collect(Collectors.toList());
        System.out.println("list size in each iteration = "+refineData(l));
    }

}
