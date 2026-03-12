public class StringASCIISumMatch {
    public static void main(String []args) {
        int a = 0, b = 0; 
        String x = "Henry";
        String y = "Peter";
        char[] p = x.toCharArray();
        char[] q = y.toCharArray();
        for(Character c : p){
            a = a + c;
        }
        for(Character d : q){
            b = b + d;
        }
        if(a == b){
            System.out.println(x+" ascii sum = "+a+" and "+y+" ascii sum = "+b+"\n");
            System.out.println(x+" and "+y+" ascii sum match perfectly");
        } else{
            System.out.println(x+" ascii sum = "+a+" and "+y+" ascii sum = "+b+"\n");
            System.out.println(x+" and "+y+" ascii sum do not match");
        }
    }

}
