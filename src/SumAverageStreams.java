import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

record Products(int id, String name, double price) {}

public class SumAverageStreams {
    public static void main(String[] args) {
        List<Products> products = Arrays.asList(
                new Products(1, "Laptop", 38999.99),
                new Products(2, "Tablet", 24299.99),
                new Products(3, "Smartphone", 32499.99),
                new Products(4, "Bluetooth", 5199.99)
        );

        // Count the total number of products
        long count = products.stream().count();
        System.out.println("Total number of products: " + count);

        long count2 = products.stream().collect(Collectors.counting());
        System.out.println("Total number of products: " + count2);

        // Calculate the total price of all products
        double totalPrice = products.stream()
                .mapToDouble(Products::price)
                .sum();
        System.out.println("Total price of all products: " + totalPrice);

        double totalPrice2 = products.stream().collect(Collectors.summingDouble(Products::price));
        System.out.println("Total price of all products: " + totalPrice2);

        // Calculate the average price of all products
        double averagePrice = products.stream()
                .mapToDouble(Products::price)
                .average()
                .orElse(0.0);
        System.out.println("Average price of all products: " + averagePrice);

        double averagePrice2 = products.stream().collect(Collectors.averagingDouble(Products::price));
        System.out.println("Average price of all products: " + averagePrice2);

        // Find the maximum and minimum priced products
        Products p1 = products.stream().max((a,b) -> a.price()>b.price()?1:-1).get();
		System.out.println("Maximum valued Product Price = "+p1.price());

        products.stream().collect(Collectors.maxBy((a,b) -> a.price()>b.price()?1:-1))
        .ifPresent(p -> System.out.println("Maximum valued Product Price = "+p.price()));

        Products p3 = products.stream().reduce((a,b) -> a.price()>b.price()?a:b).get();
		System.out.println("Product with highest price = "+p3.price());

		Products p2 = products.stream().min((a,b) -> a.price()>b.price()?1:-1).get();
		System.out.println("Minimum valued Product Price = "+p2.price());

        products.stream().collect(Collectors.minBy((a,b) -> a.price()>b.price()?1:-1))
        .ifPresent(p -> System.out.println("Minimum valued Product Price = "+p.price()));

        Products p4 = products.stream().reduce((a,b) -> a.price()<b.price()?a:b).get();
		System.out.println("Product with lowest price = "+p4.price());

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the price of Product = ");
        double n = sc.nextDouble();

        //Find the product with price equal to n
        double filteredPrice = products.stream()
                .filter(p -> p.price() == n)
                .mapToDouble(Products::price)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No product found"));
        System.out.println("Price of matched products : " + filteredPrice);

        //List of products with price greater than n
        List<Products> filteredProducts = products.stream()
                .filter(p -> p.price() > n)
                .collect(Collectors.toList());
        System.out.println("Products with price greater than " + n + ": " + filteredProducts);

    }
}