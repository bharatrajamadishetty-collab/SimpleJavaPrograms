import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

class CompletableFutureExample {
    private static Integer add(Integer a, Integer b) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return a + b;
    }

    private static Integer divide(Integer a, Integer b) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return a / b;
    }

    private static Character getCharacter(String s, Integer i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return s.charAt(i);
    }

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(
                () -> add(1527, 4728).toString() + " , using Thread : " + Thread.currentThread().getName());
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(
                () -> getCharacter("GENUINE", 3).toString() + " , using Thread : " + Thread.currentThread().getName());

        CompletableFuture<?> f3
        // java.lang.ArithmeticException: / by zero
                = CompletableFuture.supplyAsync(() -> divide(18, 0))
                        .exceptionally(ex -> 0)
                        .thenAccept(r -> {
                            // 0 - returned by exceptionally block
                            System.out.println(
                                    "Future3 Result = " + r + " , using Thread : " + Thread.currentThread().getName());
                        });

        // Running multiple tasks in parallel
        CompletableFuture<Void> allOf = CompletableFuture.allOf(f1, f2, f3);
        // Waits for all futures to complete
        allOf.join();

        System.out.println("Future1 Result = " + f1.get());
        System.out.println("Future2 Result = " + f2.get());

        var executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<Integer> c = CompletableFuture.supplyAsync(() -> add(34, 87), executorService);
        CompletableFuture<Integer> d = CompletableFuture.supplyAsync(() -> divide(45, 17), executorService);
        CompletableFuture<Integer> p = CompletableFuture.supplyAsync(() -> add(69, 73)).thenApply(s -> divide(s, 10));
        CompletableFuture<Integer> e = c.thenCombine(d, (f, g) -> divide(f, g));
        CompletableFuture<Integer> h = e.thenCombine(c, Data::new)
                .thenCompose(data -> CompletableFuture.supplyAsync(() -> add(data.k, data.l)));
        System.out.println(c.get() + " " + d.get() + " " + e.get() + " " + h.get() + " " + p.get());
    }

    record Data(Integer k, Integer l) {
    }
}
