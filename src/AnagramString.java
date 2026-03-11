import java.util.Arrays;

public class AnagramString {
    public static void main(String []args) {
        String a = "Mother In Law";
        String b = "Hitler Woman";
        a = a.replaceAll(" ","");
        b = b.replaceAll(" ","");
        a = a.toLowerCase();
        b = b.toLowerCase();
        char[] c = a.toCharArray();
        char[] d = b.toCharArray();
        Arrays.sort(c);
        Arrays.sort(d);
        if(c.length == d.length && Arrays.equals(c,d)) {
            System.out.println("The strings "+a+" and "+b+" are anagram");
        }else{
            System.out.println("The strings "+a+" and "+b+" are not anagram");
        }
    }

}
