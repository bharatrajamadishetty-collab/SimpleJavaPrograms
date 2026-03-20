import java.util.Scanner;

public class BinarySearch {
    public static int searchNumber(int[] b, int start, int end, int x) {
        if(start<=end) {
            int mid = start + (end - start)/2;
            if(b[mid] == x) {
                return mid;
            } else if(x < b[mid]) {
                return searchNumber(b, start, mid-1, x);
            } else {
                return searchNumber(b, mid+1, end, x);
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number to be searched  = ");
            int n = sc.nextInt();
            int[] a = {1,2,6,7,9,13,18,23,28,35};
            int i = searchNumber(a,0,a.length,n);
            if(i == -1) {
                System.out.println(n+" is not present in the array");
            } else {
                System.out.println(n+" is present at index = "+i);
            }
        }
    }

}
