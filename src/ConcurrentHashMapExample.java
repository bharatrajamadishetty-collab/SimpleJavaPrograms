import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        int initialCapacity = 1;
        float loadFactor = 0.1f;
        int concurrencyLevel = 3;
        ConcurrentHashMap<Integer,String> m = new ConcurrentHashMap<>(initialCapacity, loadFactor, concurrencyLevel);
        Employee e1 = new Employee("Alice", 1);
        Employee e2 = new Employee("Bob", 2);
        Employee e3 = new Employee("Charlie", 3);
        m.put(e1.getId(), e1.getName());
        m.put(e2.getId(), e2.getName());
        m.put(e3.getId(), e3.getName());

        System.out.println("Initial Capacity: " + initialCapacity);
        System.out.println("Load Factor: " + loadFactor);
        System.out.println("Concurrency Level: " + concurrencyLevel);

        for(Map.Entry<Integer, String> entry : m.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue() + " , using Thread : " + Thread.currentThread().getName());
        }
    }
}
