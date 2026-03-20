import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

record User(int id, String name, String role) {}

public class PredicateStreams {
    public static void main(String args[]) {
        List<User> users = Arrays.asList(
                new User(1, "Alice", "admin"),
                new User(2, "Bob", "user"),
                new User(3, "Charlie", "admin"),
                new User(4, "David", "user")
        );

        // Filter users with role 'admin'
        Predicate<User> isAdmin = user -> user.role().equals("admin");
        users.stream()
                .filter(isAdmin)
                .forEach(admin -> System.out.println("Admin user:" + admin.name()));

        // Find the first user with role 'user'
        Predicate<User> isUser = user -> user.role().equals("user");
        users.stream()
                .filter(isUser)
                .findFirst()
                .ifPresent(user -> System.out.println("First user found: " + user.name()));

        
        List<String> userNames = users.stream().map(User::name).collect(Collectors.toList());
        userNames.stream().filter(n -> n.startsWith("A")).forEach(System.out::println);
        userNames.stream().filter(n -> n.contains("B")).forEach(System.out::println);

        try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Enter the name of User = ");
                String name = sc.next();

                // Find the user with the specified name
                Predicate<User> hasName = user -> user.name().equals(name);
                Optional<User> u = Optional.of(users.stream()
                        .filter(hasName)
                        .findFirst()
                        .get());
                        if(u.isPresent()) {
                            System.out.println("User found with Id: " + u.get().id() + " name: " + u.get().name() + " role: " + u.get().role());
                        }
        }
    }

}
