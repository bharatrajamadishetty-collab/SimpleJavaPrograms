
import java.util.LinkedList;
import java.util.List;

public class OpenCloseClearOnChoice {
    static List<String> operations(List<String> list) {
        LinkedList<String> result = new LinkedList<>();
        list.forEach(s -> {
            if (s.startsWith("open")) {
                result.add(s.substring(s.indexOf(" ") + 1));
                System.out.println("Opening " + result.getLast());
            } else if (s.startsWith("close")) {
                for (int i = 0; i < Integer.parseInt(s.substring(s.length() - 1)); i++) {
                    if (!result.isEmpty()) {
                        System.out.println("Closing " + result.getLast());
                        result.removeLast();
                    }
                }
            } else if (s.equals("clear")) {
                System.out.println("Closing all tabs");
                result.clear();
            }
        });
        return result;
    }

    public static void main(String[] args) {
        List<String> l1 = List.of("open chrome", "open google", "open firefox", "close 2", "open opera", "open google",
                "clear",
                "open firefox");
        System.out.println("Retaining " + operations(l1));
        List<String> l2 = List.of("clear", "open google", "open firefox", "close 3", "open opera", "open google",
                "close1",
                "open chrome");
        System.out.println("Retaining " + operations(l2));
        List<String> l3 = List.of("close1", "open google", "open firefox", "open opera", "close 2", "open edge",
                "open chrome");
        System.out.println("Retaining " + operations(l3));
    }

}
