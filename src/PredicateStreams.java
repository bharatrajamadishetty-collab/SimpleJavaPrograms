import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Predicate;
import java.util.stream.Collectors;

record User(int id, String name, String role) {}
//Using Unnamed Class
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
        
        //Using flatmap to flatten list elements
        List<List<String>> nameList = Arrays.asList(
                Arrays.asList("Alice", "James"),
                Arrays.asList("Clarke", "Henry"),
                Arrays.asList("David", "Peter")
        );
        List<String> names = nameList.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println("Names List Pair : " + nameList);
        System.out.println("Flattened Names List : " + names);

        Set<List<String>> s = new HashSet<>();
        s.add(Arrays.asList("Alice", "Henry"));
        s.add(Arrays.asList("James", "Charlie"));
        Set<String> flatSet = s.stream().flatMap(y -> y.stream()).collect(Collectors.toSet());
        System.out.println("Flattened Names Set = "+flatSet);

        Map<Integer,List<String>> mp = new HashMap<>();
        mp.put(1,Arrays.asList("Clarke", "Peter"));
        mp.put(2,Arrays.asList("David", "Henry"));
        List<String> flatList = mp.values().stream().flatMap(z -> z.stream()).collect(Collectors.toList());
        System.out.println("Flattened map values = "+flatList);

        Queue<List<String>> q = new ConcurrentLinkedQueue<>();
        q.add(Arrays.asList("Peter", "Bob"));
        q.add(Arrays.asList("Henry", "James"));
        List<String> flatQueue = q.stream().flatMap(f -> f.stream()).collect(Collectors.toList());
        System.out.println("Flattened queue list = "+flatQueue);
    }
