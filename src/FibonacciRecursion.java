import java.util.Scanner;

public class FibonacciRecursion {
    public static int fib(int x) {
        if(x<=1){
            return x;
        }
        return fib(x-1)+fib(x-2);
    }
    public static void main(String []args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the limit of fibonacci series: ");
        int n = s.nextInt();
        System.out.println("The fibonacci series for limit "+n+" is: ");
        for(int i=0; i<n; i++){
        System.out.print(fib(i)+" ");
        }
        System.out.println("\n Reverse fibonacci series for limit "+n+" is: ");
        for(int j=n-1; j>=0; j--){
        System.out.print(fib(j)+" ");
        }
    }
}
