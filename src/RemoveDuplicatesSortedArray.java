import java.util.Arrays;
import java.util.stream.IntStream;

public class RemoveDuplicatesSortedArray {
    static int[] removeDuplicatesUsingIntStream(int[] b) {
        return IntStream.range(0, b.length)
                .filter(i -> i == 0 || b[i] != b[i - 1])
                .map(i -> b[i])
                .toArray();
    }

    static int[] removeDuplicates(int[] d) {
        int i = 0;
        for (int j = 1; j < d.length; j++) {
            if (d[j] != d[i]) {
                i++;
                d[i] = d[j];
            }
        }
        return Arrays.copyOf(d, i + 1);
    }

    public static void main(String[] args) {
        int[] a = { 1, 1, 2, 3, 4, 4, 6, 7, 7, 7, 8, 9, 9, 9 };
        System.out.println(Arrays.toString(removeDuplicatesUsingIntStream(a)));
        System.out.println(Arrays.toString(removeDuplicates(a)));
    }

}
