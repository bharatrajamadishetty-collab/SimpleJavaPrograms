import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

record EmployeeX(int id, String name, String dept, double salary) {
}

public class DepartmentWiseSalary {
        public static void main(String[] args) {
                List<EmployeeX> employees = Arrays.asList(
                                new EmployeeX(1, "Alice", "Sales", 50000),
                                new EmployeeX(2, "Bob", "IT", 60000),
                                new EmployeeX(3, "Charlie", "Finance", 55000),
                                new EmployeeX(4, "David", "IT", 70000),
                                new EmployeeX(5, "Dwane", "HR", 150000),
                                new EmployeeX(6, "Peter", "Finance", 50000),
                                new EmployeeX(7, "Alice", "IT", 90000));

                List<EmployeeX> listAscending = employees.stream()
                                .sorted(Comparator.comparing(EmployeeX::salary))
                                .toList();
                System.out.println("Sorted Employees by lowest to highest salary : " + listAscending);

                List<EmployeeX> listDescending = employees.stream()
                                .sorted(Comparator.comparing(EmployeeX::salary).reversed())
                                .toList();
                System.out.println("Sorted Employees by highest to lowest salary : " + listDescending);

                Map<String, Optional<EmployeeX>> collect = employees.stream()
                                .collect(Collectors.groupingBy(
                                                EmployeeX::dept,
                                                Collectors.maxBy(Comparator.comparing(EmployeeX::salary))));
                System.out.println("Max salaried Employee in each department : " + collect);

                List<String> list = employees.stream()
                                .collect(Collectors.groupingBy(EmployeeX::dept, Collectors.counting()))
                                .entrySet().stream()
                                .filter(e -> e.getValue() > 1)
                                .map(Map.Entry::getKey)
                                .toList();
                System.out.println("List of departments having more than one Employee : " + list);

                Map<String, Double> m = employees.stream()
                                .collect(Collectors.groupingBy(EmployeeX::dept,
                                                Collectors.averagingDouble(EmployeeX::salary)));
                System.out.println("Average salary in each department : " + m);

                Entry<String, Double> entry = m.entrySet().stream()
                                .max(Map.Entry.comparingByValue())
                                .orElseThrow(() -> new RuntimeException("No departments found"));
                System.out.println("Highest average salary of all departments : " + entry);

                List<String> nameList = employees.stream()
                                .collect(Collectors.groupingBy(EmployeeX::name))
                                .entrySet().stream()
                                .filter(f -> f.getValue().size() >= 2)
                                .map(Map.Entry::getKey)
                                .toList();
                System.out.println("List of Employees in more two or more departments : " + nameList);
        }

}
