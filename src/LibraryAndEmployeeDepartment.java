import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

record DemoEmployee(String name, int id, String department, double salary) {
}

record Book(String name, String genere, double price) {
}

public class LibraryAndEmployeeDepartment {
        private static void getSpecificGenereBooksCountAndTotalPrice() {
                List<Book> books = List.of(
                                new Book("The Great Gatsby", "Fiction", 12.99),
                                new Book("To Kill a Mockingbird", "Fiction", 14.99),
                                new Book("1984", "Dystopian", 13.99));

                long count = books.stream().filter(book -> book.genere().equals("Fiction")).count();
                System.out.println("Number of Fiction books: " + count);
                double totalPrice = books.stream().filter(book -> book.genere().equals("Fiction")).map(m -> m.price())
                                .collect(Collectors.summingDouble(Double::doubleValue));
                System.out.println("Total value of Fiction books: " + totalPrice);
        }

        private static void getDepartmentWiseMaxSalary() {
                List<DemoEmployee> employees = List.of(
                                new DemoEmployee("Alice", 1, "Engineering", 75000.0),
                                new DemoEmployee("Ace", 2, "Engineering", 50000.0),
                                new DemoEmployee("Bob", 3, "Marketing", 65000.0),
                                new DemoEmployee("Charlie", 4, "Sales", 60000.0),
                                new DemoEmployee("Charlie", 4, "Sales", 61000.0));

                employees.stream()
                                .collect(Collectors.groupingBy(DemoEmployee::department,
                                                Collectors.maxBy(Comparator.comparing(DemoEmployee::salary))))
                                .forEach((dept, emp) -> System.out
                                                .println(dept + ": " + emp.map(DemoEmployee::salary).orElse(0.0)));
        }

        public static void main(String[] args) {
                getSpecificGenereBooksCountAndTotalPrice();

                getDepartmentWiseMaxSalary();
        }

}
