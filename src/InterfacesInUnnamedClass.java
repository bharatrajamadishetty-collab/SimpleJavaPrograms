interface Free {
    void call(String s);

    default void call(int i) {
        System.out.println("This is a default method in the Free interface." + ++i);
    }
}

interface Sms {
    void call(String s);

    default void call(int i) {
        System.out.println("This is a default method in the Sms interface." + --i);
    }
}

void main() {
    Free f = (s) -> {
        System.out.println("Hello! " + s);
    };
    f.call("Doctor Strange");
    f.call(5);

    Sms sms = (s) -> {
        System.out.println("SMS: " + s);
    };
    sms.call("Doctor Strange");
    sms.call(10);
}
