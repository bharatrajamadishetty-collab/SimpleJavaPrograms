import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

record NthHighestSalaryEmployee(int id, String name, double salary) {}

public class NthHighestSalary {
public static void main(String[] args) {
        List<NthHighestSalaryEmployee> employees = Arrays.asList(
            new NthHighestSalaryEmployee(1, "Alice", 50000),
            new NthHighestSalaryEmployee(2, "Bob", 60000),
            new NthHighestSalaryEmployee(3, "Charlie", 55000),
            new NthHighestSalaryEmployee(4, "David", 70000),
            new NthHighestSalaryEmployee(5, "Eve", 65000),
            new NthHighestSalaryEmployee(6, "Steve", 65000)
        );

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter n value to get nth highest salary = ");
            int n = sc.nextInt();

            double nthHighestSalary = employees.stream()
                .map(NthHighestSalaryEmployee::salary)
                .sorted(Comparator.reverseOrder()) // Sort in descending order
                .skip(n - 1) // Skip the first n-1 salaries
                .findFirst() // Get the nth highest salary
                .orElseThrow(() -> new IllegalArgumentException("nth highest salary not found")); // Throw an exception if n is out of bounds
                System.out.println(n + "th highest salary: " + nthHighestSalary);
            employees.stream()
                .filter(e -> e.salary() == nthHighestSalary)
                .forEach(e -> System.out.println("employee name = " + e.name()));

            employees.stream()
                .sorted(Comparator.comparingDouble(NthHighestSalaryEmployee::salary).reversed())
                .distinct()
                .skip(n - 1)
                .findFirst()
                .ifPresent(e -> System.out.println(n + "th highest salary: " + e.salary() + "\nemployee name = " + e.name()));

            // Alternatively, you can sort the employees by salary and then get the nth highest salary
            employees.sort(Comparator.comparingDouble(NthHighestSalaryEmployee::salary).reversed());
            System.out.println(n + "th highest salary: " + employees.get(n - 1).salary() + "\nemployee name = " + employees.get(n - 1).name());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
