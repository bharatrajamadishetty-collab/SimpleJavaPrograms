public class GenericExample<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public static void main(String[] args) {
        GenericExample<Integer> g1 = new GenericExample<>();  // Box is now type-safe
        g1.setValue(1);  
        Integer i = g1.getValue();  
        System.out.println(i);
        GenericExample<String> g2 = new GenericExample<>();  // Box is now type-safe
        g2.setValue("Hello");  
        String s = g2.getValue();  
        System.out.println(s);
        GenericExample<Double> g3 = new GenericExample<>();  // Box is now type-safe
        g3.setValue(3.14);  
        Double d = g3.getValue();  
        System.out.println(d);
        GenericExample<Boolean> g4 = new GenericExample<>();  // Box is now type-safe
        g4.setValue(true);  
        Boolean  b = g4.getValue();  
        System.out.println(b);
        GenericExample<Character> g5 = new GenericExample<>();  // Box is now type-safe
        g5.setValue('Z');  
        Character c = g5.getValue();  
        System.out.println(c);
    }
}
