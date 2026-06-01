
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

record Emp(int eId, String ename, double sal, Integer mgrId) {
}

enum SalaryRange {
    LOW, // 0–50k
    MEDIUM, // 50k–100k
    HIGH // 100k+
}

public record SalaryRangeGrouping() {

    static SalaryRange getSalaryRange(double sal) {
        return switch (sal < 50000 ? 0 : sal > 100000 ? 1 : 2) {
            case 0 -> SalaryRange.LOW;
            case 1 -> SalaryRange.HIGH;
            default -> SalaryRange.MEDIUM;
        };
    }

    public static void main(String[] args) {
        List<Emp> l = Arrays.asList(
                new Emp(1, "Laura", 278560, null),
                new Emp(2, "Ben", 24561, 1),
                new Emp(3, "Stain", 78561, 1),
                new Emp(4, "Parker", 375619, 2),
                new Emp(5, "Amy", 98748, 3));

        Emp emp = l.stream().sorted((a, b) -> Double.compare(b.sal(), a.sal())).skip(2).findFirst().get();
        System.out.println("Third highest salaried employee : " + emp);
        l.sort((a, b) -> Double.compare(b.sal(), a.sal()));
        System.out.println("\nEmployees sorted with their salaries from highest to lowest  : " + l);

        var map = l.stream().collect(Collectors.groupingBy(e -> getSalaryRange(e.sal())));
        System.out.println("\nEmployees grouped within their salary range  : " + map);

        l.stream().flatMap(
                e -> l.stream().filter(m -> e.mgrId() != null && m.eId() == e.mgrId())
                        .map(m -> m.ename() + " is the manager of " + e.ename()))
                .forEach(System.out::println);

        l.stream().filter(e -> e.mgrId() == null).forEach(e -> System.out.println(e.ename() + " is a chief manager"));

    }

}
