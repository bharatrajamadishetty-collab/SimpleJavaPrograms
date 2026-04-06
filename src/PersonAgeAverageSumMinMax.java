import java.util.Arrays;
import java.util.List;

record Person(String name, int age) {
}

public class PersonAgeAverageSumMinMax {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 55),
                new Person("Bob", 30),
                new Person("Charlie", 28),
                new Person("David", 35));

        double avg = people.stream()
                .mapToInt(Person::age)
                .average()
                .orElse(0.0);
        System.out.println("Average age = " + avg);

        int sum = people.stream()
                .mapToInt(Person::age)
                .sum();
        System.out.println("Sum of all ages = " + sum);

        int min = people.stream()
                .mapToInt(Person::age)
                .min().getAsInt();
        System.out.println("Youngest age = " + min);

        int max = people.stream()
                .mapToInt(Person::age)
                .max()
                .orElse(0);
        System.out.println("Eldest age = " + max);

        // using reduce
        int sumReduce = people.stream()
                .mapToInt(Person::age)
                .reduce(0, Integer::sum);
        System.out.println("Sum of all ages using reduce = " + sumReduce);

        double avgReduce = people.stream()
                .mapToInt(Person::age)
                .reduce(0, Integer::sum) / people.size();
        System.out.println("Average age using reduce = " + avgReduce);

        int maxReduce = people.stream()
                .mapToInt(Person::age)
                .reduce(Integer::max).getAsInt();
        System.out.println("Eldest age using reduce = " + maxReduce);

        int minReduce = people.stream()
                .mapToInt(Person::age)
                .reduce(0, Integer::min);
        System.out.println("Youngest age using reduce = " + minReduce);

        int productReduce = people.stream()
                .mapToInt(Person::age)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product of all ages using reduce = " + productReduce);

    }

}
