import java.util.ArrayList;
import java.util.List;

public class NumberSequenceList {
    public static void main(String[] args) {
        Integer[] a = { 1, 5, 6, 9, 3, 4, 5, 1, 14, 15, 16, 17, 18 };

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        for (Integer i : a) {
            if (current.isEmpty() || a[i] == current.get(current.size() - 1) + 1) {
                current.add(a[i]);
            } else {
                if (current.size() > 1) {
                    result.add(new ArrayList<>(current));
                }
                current.clear();
                current.add(a[i]);
            }
        }
        if (current.size() > 1) {
            result.add(current);
        }
        System.out.println(result);

    }

}
