import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

record Employee(String name, int id) {}

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        int initialCapacity = 1;
        float loadFactor = 0.1f;
        int concurrencyLevel = 3;
        ConcurrentHashMap<Integer,String> m = new ConcurrentHashMap<>(initialCapacity, loadFactor, concurrencyLevel);
        Employee e1 = new Employee("Alice", 1);
        Employee e2 = new Employee("Bob", 2);
        Employee e3 = new Employee("Charlie", 3);
        Employee e = new Employee(null, 4);
        Employee e4 = new Employee(null, 5);
        //Using Record Patterns
        if(e1 instanceof Employee(String name, int id)){
            m.put(id, name);
        }
        m.put(e2.id(), e2.name());
        m.put(e3.id(), e3.name());
        m.forEach((k,v) -> System.out.println(k+":"+v));
        m.putIfAbsent(e.id(), e2.name());
        m.replace(e2.id(), e1.name());
        m.computeIfPresent(e1.id(), (k, v) -> e3.name());
        m.computeIfAbsent(e4.id(), k -> "Glenn");

        System.out.println("Initial Capacity: " + initialCapacity);
        System.out.println("Load Factor: " + loadFactor);
        System.out.println("Concurrency Level: " + concurrencyLevel);

        for(Map.Entry<Integer, String> entry : m.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue() + " , using Thread : " + Thread.currentThread().getName());
        }
    }
}
