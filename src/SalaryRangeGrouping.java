
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

record Emp(int id, String ename, double sal) {
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
                new Emp(1, "Laura", 278560),
                new Emp(2, "Ben", 24561),
                new Emp(3, "Stain", 78561),
                new Emp(4, "Parker", 375619),
                new Emp(5, "Amy", 98748));

        Emp emp = l.stream().sorted((a, b) -> Double.compare(b.sal(), a.sal())).skip(2).findFirst().get();
        System.out.println("Third highest salaried employee : " + emp);
        l.sort((a, b) -> Double.compare(b.sal(), a.sal()));
        System.out.println("\nEmployees sorted with their salaries from highest to lowest  : " + l);

        var map = l.stream().collect(Collectors.groupingBy(e -> getSalaryRange(e.sal())));
        System.out.println("\nEmployees grouped within their salary range  : " + map);

    }

}
