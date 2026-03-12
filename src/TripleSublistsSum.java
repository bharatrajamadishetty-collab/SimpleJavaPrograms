import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TripleSublistsSum {
    public static List<List<Integer>> listSubLists(int[] a) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the target sum = ");
    int t = sc.nextInt();
        List<List<Integer>> sbl = new ArrayList<List<Integer>>();
        for(int i=0; i<a.length-1; i++) {
            for(int j=i+2; j<a.length; j++) {
                if(a[i]+a[i+1]+a[j] == t) {
                    List<Integer> li = new ArrayList<Integer>();
                    li.add(a[i]);
                    li.add(a[i+1]);
                    li.add(a[j]);
                    sbl.add(li);
                }
            }
        }
        return sbl;
    }
    public static void main(String args[]) {
        int[] i = {1,0,-1,2,1,4,-1};
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        r = listSubLists(i);
        System.out.println("Result Triplets = "+r);   // If t = 0, Result Triplets = [[1, 0, -1], [1, 0, -1], [0, -1, 1], [-1, 2, -1]]
    }

}
