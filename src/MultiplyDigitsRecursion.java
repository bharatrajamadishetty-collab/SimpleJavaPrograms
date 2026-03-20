//Count the number of times the digits of a number can be multiplied till the product results a single digit: 
//persistence(39) -> 3 // because 3*9 = 27, 2*7 = 14, 1*4=4

import java.util.Scanner;

public class MultiplyDigitsRecursion {
    public static int getProduct(int n) {
        int a = 1;
        int c = 0;
        if(n > 9) {
            while(n > 0) {
                a = a*(n%10); 
                n = n/10;                    
                if(n == 0) {
                    c++;
                    System.out.println("Product of all digits = "+a); 
                    if(a > 9) {
                        n = a;
                        a = 1;
                    }else{
                        break;
                    }
                }
            }
        }
        return c;
    }

    //Using Recursion
    private static int getProductRecursion(int n, int c){
        if(n > 9) {
            int x = n/10;
            int y = n%10; 
            n = x * y;  
            if(x > 0){
                System.out.println(x+" * "+y+" = "+n);
                return getProductRecursion(n, ++c);
            }           
        }
        return c;
    }
    public static void main(String []args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number: ");
            int n = sc.nextInt();
            System.out.println("Final Result = "+getProduct(n));
            System.out.println("---------Printing using recursion----------");
            System.out.println("Final Result using recursion = "+getProductRecursion(n,0));
        }
    }

}
