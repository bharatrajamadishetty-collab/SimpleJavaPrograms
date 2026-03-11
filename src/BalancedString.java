import java.util.Stack;

public class BalancedString {
static boolean isBalancedString(String b) {
        char c;
        char d;
        Stack<Character> s = new Stack<Character>();
        for(int i=0; i<b.length(); i++) {
            c = b.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                s.push(c);
                continue;
            }
            if(s.isEmpty()) {
                return false;
            }
            switch(c) {
            case ')' :
                d = s.pop();
                if(d != '(') {
                    return false;
                }
                break;
            case ']' :
                d = s.pop();
                if(d != '[') {
                    return false;
                }
                break;
            case '}' :
                d = s.pop();
                if(d != '{') {
                    return false;
                }
                break;
            }
        }
        return (s.isEmpty());
    }
    public static void main(String []args) {
        String b = "{[()]}";
        if(isBalancedString(b)) {
            System.out.println(b+ " is a Balanced String");
        } else {
            System.out.println(b+ " is not a Balanced String");
        }
        System.out.println(isBalancedString("{[(])}") ? " {[(])} is a Balanced String" : " {[(])} is not a Balanced String");
    }

}
