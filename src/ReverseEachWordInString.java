public class ReverseEachWordInString {
    
    public static String reverseStringBuilder(String x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.reverse();
        return sb.toString();
    }
    public static String reverseStringBuffer(String x) {
        StringBuffer sb = new StringBuffer(x);
        sb.reverse();
        return sb.toString();
    }
    public static void main(String []args) {
        String s = "best friends forever";
        String b = new String();
        String c = new String();
        StringBuilder sl = new StringBuilder();
        StringBuffer sb = new StringBuffer();
        String[] a = s.split("\\s");
        for(String t : a) {
            //using StringBuilder
            b = reverseStringBuilder(t);
            sl.append(b);
            sl.append(" ");
            //using StringBuffer
            c = reverseStringBuffer(t);
            sb.append(c);
            sb.append(" ");
        }
        System.out.println("Reversing each word in the string = "+sl.toString());
        System.out.println("Reversing each word in the string = "+sb.toString());
    }

}
