
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Prime {
    static void primeNumbers(int n) {
        List<Integer> l = IntStream.rangeClosed(2, n)
                .filter(j -> IntStream.rangeClosed(2, (int) Math.sqrt(j))
                        .noneMatch(i -> j % i == 0))
                .boxed().toList();
        System.out.println("List of prime numbers between 1 and " + n + " : " + l);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the prime numbers range: ");
            int n = sc.nextInt();
            primeNumbers(n);
            List<Integer> l = new ArrayList<>();
            boolean isPrime = false;

            for (int j = 2; j <= n; j++) {
                if (j == 2 || j == 3) {
                    isPrime = true;
                }
                for (int i = 2; i <= Math.sqrt(j); i++) {
                    if (j % i == 0) {
                        isPrime = false;
                        break;
                    } else {
                        isPrime = true;
                    }
                }
                if (isPrime) {
                    l.add(j);
                }

            }

            System.out.println("List of prime numbers between 1 and " + n + " : " + l);
        }
    }

}
