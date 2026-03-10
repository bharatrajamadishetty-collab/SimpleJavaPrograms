
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 1),
            new Employee("Bob", 2),
            new Employee("Charlie", 3),
            new Employee("David", 4),
            new Employee("Eve", 5)
        );

        List<String> employeeNames = employees.parallelStream()
                                              .map(Employee::getName)
                                              .collect(Collectors.toList());
        System.out.println(employeeNames);

        List<Integer> employeeIds = employees.parallelStream()
                                              .map(Employee::getId)
                                              .collect(Collectors.toList());
        System.out.println(employeeIds);

        System.out.println("Unordered Employee Details:");
        employees.parallelStream().forEach(e -> System.out.println("Employee Name: " + e.getName() + ", Employee ID: " + e.getId() + " , using Thread : " + Thread.currentThread().getName()));
        System.out.println("Ordered Employee Details:");
        employees.parallelStream().forEachOrdered(e -> System.out.println("Employee Name: " + e.getName() + ", Employee ID: " + e.getId() + " , using Thread : " + Thread.currentThread().getName()));   
    }

}
