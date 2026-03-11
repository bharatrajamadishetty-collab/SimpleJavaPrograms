public class ReverseEachWordInString {
    
    public static String reverseString(String x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.reverse();
        return sb.toString();
    }
    public static void main(String []args) {
        String s = "best friends forever";
        String b = new String();
        StringBuilder sl = new StringBuilder();
        String[] a = s.split(" ");
        for(String t : a) {
            b = reverseString(t);
            sl.append(b);
            sl.append(" ");
        }
        System.out.println("Reversing each word in the string = "+sl.toString());
    }

}
