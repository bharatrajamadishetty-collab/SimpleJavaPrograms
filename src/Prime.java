
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the prime numbers range: ");
            int n = sc.nextInt();
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
