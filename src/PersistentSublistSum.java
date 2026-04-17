
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersistentSublistSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the values of the list size and sum of numbers in the list");
        int k = s.nextInt(); // 1<=k<=n
        int n = s.nextInt(); // k<=n<=45 (1+2+...+9)
        List<Integer> l = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            n = n - i;
            if (n >= 0) {
                l.add(i);
            } else {
                n = n + l.get(l.size() - 1);
                l.remove(l.size() - 1);
                l.add(i);
            }
            if (n == 0 && l.size() == k)
                break;
        }
        System.out.println(l);

    }

}
