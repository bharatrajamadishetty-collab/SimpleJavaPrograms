import java.util.random.RandomGenerator;

public class VirtualThreadExecutor {
    static int counter(){
        int c =0;
        for (int i = 0; i < 55; i++) {
            c++;
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.ofVirtual().name(""));
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        //Random Number Generator
        RandomGenerator rng = RandomGenerator.of("L64X128MixRandom");
        int number = rng.nextInt();
        System.out.println(number);
        //Streamable Random Numbers
        RandomGenerator.getDefault().ints(3).forEach(System.out::println);

        //Normal OS Thread
        new Thread(() -> counter()).start();
        //Virtual JVM Thread
        Thread.startVirtualThread(() -> counter());

    //Text Block
    String json = """
    {
    "orderId": 3251,
    "price": 38.25,
    "Token number": 1573,
    "data": [
        {
            "id": 1,
            "Name": "Choc Cake",
            "Image": "1.jpg",
            "Category": "Meal",
            "Method": "",
            "Ingredients": [
                {
                    "name": "1 Cup Ice"
                },
                {
                    "name": "1 Bag Beans"
                },
                {
                    "name": "4 Bag Gems"
                },
                {
                    "name": "6 Bag Choco"
                }
            ]
        },
        {
            "id": 2,
            "Name": "Ice Cake",
            "Category": "Meal",
            "Method": ""
        }
    ],
    "quantity": 4
    }
        """;

        System.out.println(json);
    }

}
