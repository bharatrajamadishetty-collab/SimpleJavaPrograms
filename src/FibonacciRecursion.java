import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciRecursion {
    // using streams
    static List<Integer> fibo(int y) {
        return Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] }).limit(y).map(m -> m[0])
                .toList();
    }

    static String reversefibo(int y) {
        List<Integer> l = Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] }).limit(y)
                .map(m -> m[0]).toList();
        return Arrays.toString(IntStream.range(0, y).map(m -> l.get(y - 1 - m)).toArray());
    }

    public static int fib(int x) {
        if (x <= 1) {
            return x;
        }
        return fib(x - 1) + fib(x - 2);
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Enter the limit of fibonacci series: ");
            int n = s.nextInt();
            System.out.println("The fibonacci series for limit " + n + " is: ");
            for (int i = 0; i < n; i++) {
                System.out.print(fib(i) + " ");
            }
            System.out.println("\n Reverse fibonacci series for limit " + n + " is: ");
            for (int j = n - 1; j >= 0; j--) {
                System.out.print(fib(j) + " ");
            }
            System.out.println(fibo(n));
            System.out.println(reversefibo(n));
        }
    }
}
