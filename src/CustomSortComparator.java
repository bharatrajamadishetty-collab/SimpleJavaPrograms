import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Product implements Comparable<Product>{
    private final int id;
    private final String name;
    private final double price;
    private final String model;

    public Product(int id, String name, double price, String model) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
    
    public String getModel() {
        return model;
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }

}

class NameComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

public class CustomSortComparator {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", 38999.99, "XPS 15"),
                new Product(2, "Tablet", 24299.99, "iPad Pro"),
                new Product(3, "Smartphone", 32499.99, "Galaxy S21"),                
                new Product(4, "Bluetooth", 5199.99, "JBL Flip 5")
        );

        // Sort products by price using natural ordering (Comparable)
        Collections.sort(products);
        System.out.println("Products sorted by price:");
        products.forEach(p -> System.out.println(p.getId() + " . " + p.getName() + " : $" + p.getPrice() + " : " + p.getModel()));
        
        // Sort products by name using a custom Comparator
        Collections.sort(products, new NameComparator());
        System.out.println("\nProducts sorted by name:");
        products.forEach(p -> System.out.println(p.getId() + " . " + p.getName() + " : $" + p.getPrice() + " : " + p.getModel()));
        
        // Sort products by name and then by model using Comparator chaining
        products.sort(Comparator.comparing(Product::getName, Comparator.reverseOrder()).thenComparing(Product::getModel, Comparator.naturalOrder()));
        System.out.println("\nProducts sorted by name and model:");
        products.forEach(p -> System.out.println(p.getId() + " . " + p.getName() + " : $" + p.getPrice() + " : " + p.getModel()));
    }

}
