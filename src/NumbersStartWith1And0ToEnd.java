import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumbersStartWith1And0ToEnd {

    private static int[] moveZerosToEndUsingStream(int[] a) {
        int[] result = IntStream.concat(
                Arrays.stream(a).filter(x -> x != 0),
                Arrays.stream(a).filter(x -> x == 0)).toArray();
        return result;
    }

    private static int[] moveZerosToEnd(int[] a) {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                j++;
            }
        }
        return a;
    }

    private static List<Integer> getNumbersStartingWith1(List<Integer> numbers) {
        List<Integer> numbersStartingWith1 = numbers.stream()
                .filter(n -> {
                    while (n >= 10) {
                        n /= 10;
                    }
                    return n == 1;
                })
                .toList();
        return numbersStartingWith1;
    }

    public static void main(String[] args) {
        int[] a = { 5, 0, 17, 0, 0, 46, 39, 0 };

        // Move all zeros to the end
        System.out.println(Arrays.toString(moveZerosToEndUsingStream(a)));
        System.out.println(Arrays.toString(moveZerosToEnd(a)));

        List<Integer> numbers = List.of(1, 2, 13, 41, 125, 1946);

        List<Integer> numbersStartingWith1 = getNumbersStartingWith1(numbers);

        System.out.println(numbersStartingWith1);

    }

}
