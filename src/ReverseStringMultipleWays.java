
class ReverseStringMultipleWays {
    static String reverseSwapString(String a) {
        char[] c = a.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
        }
        return new String(c);
    }

    static String reverseString(String d) {
        for (int k = 0; k < d.length() / 2; k++) {
            char t = d.charAt(k);
            d = d.substring(0, k) + d.charAt(d.length() - 1 - k)
                    + d.substring(k + 1, d.length() - 1 - k) + t + d.substring(d.length() - k);
        }
        return d;
    }

    static String reverseStringBuilder(String b) {
        StringBuilder sb = new StringBuilder();
        sb.append(b);
        sb.reverse();
        return sb.toString();
    }

    static String reversewithStreamMap(String f) {
        return f.chars().mapToObj(m -> f.charAt(f.length() - 1 - f.indexOf(m)))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }

    static String reverseWithStreamForEach(String g) {
        StringBuilder r = new StringBuilder();
        g.chars().forEach(x -> {
            r.append(g.charAt(g.length() - 1 - g.indexOf(x)));
        });
        return r.toString();
    }

    public static void main(String args[]) {
        String s = "danger";
        System.out.println("reversed string = " + reverseSwapString(s));
        System.out.println("reversed string = " + reverseStringBuilder(s));
        System.out.println("reversed string = " + reversewithStreamMap(s));
        System.out.println("reversed string = " + reverseWithStreamForEach(s));
        System.out.println("reversed string = " + reverseString("superman"));
    }
}
