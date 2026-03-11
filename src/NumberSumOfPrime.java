import java.util.ArrayList;
import java.util.List;

public class NumberSumOfPrime {
    static boolean isPrime(int a) {
        for(int i=2; i<=Math.sqrt(a); i++)
            if(a%i == 0)
                return false;
        return true;
    }
    public static void main(String []args) {
        int n=66;  //{63+3|61+5|59+7|53+13|47+19|43+23|37+29}
        //int n=19;  {2+17}
        if(n<4) {
            System.out.println(n+" cannot be written as the sum of two prime numbers");
        } else {
            if(n%2 != 0) {
                if(isPrime(n-2)) {
                    System.out.println(n+" can be written as the sum of two prime numbers");
                } else {
                    System.out.println(n+" cannot be written as the sum of two prime numbers");
                }
            } else {
                int c = 0;
                List<Integer> al = new ArrayList<>();
                for(int i=2; i<=n; i++) {
                    if(isPrime(i)) {
                        al.add(i);
                    }
                }
                for(Integer x : al) {
                    if(isPrime(n-x)) {
                        c++;
                    }
                }
                if(c > 0) {
                    System.out.println(n+" can be written as the sum of two prime numbers");
                } else {
                    System.out.println(n+" cannot be written as the sum of two prime numbers");
                }
            }
        }
    }

}
