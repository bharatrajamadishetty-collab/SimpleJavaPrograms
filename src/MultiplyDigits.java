//Count the number of times the digits of a number can be multiplied till the product results a single digit: 
//persistence(39) -> 3 // because 3*9 = 27, 2*7 = 14, 1*4=4

import java.util.Scanner;

public class MultiplyDigits {
 public static int getProduct(int n) {
        int a = 1;
        int c = 0;
        if(n > 9) {
            while(n > 0) {
                a = a*(n%10); 
                n = n/10;     
                if(n == 0) {
                    c++;
                    if(a > 9) {
                        n = a;
                        a = 1;
                        System.out.println("digits product = "+n);
                    }else{
                        System.out.println("digits product = "+a);
                        break;
                    }
                }
            }
        }
        return c;
    }
    public static void main(String []args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        int count = getProduct(n);
        System.out.println("Final Result = "+count);
    }

}
