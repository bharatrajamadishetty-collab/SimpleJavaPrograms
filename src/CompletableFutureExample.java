import java.util.concurrent.CompletableFuture;

class CompletableFutureExample {
    private static Integer add(Integer a,Integer b) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return a + b;
    }

    private static Integer divide(Integer a,Integer b) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return a / b;
    }

    private static Character getCharacter(String s,Integer i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return s.charAt(i);
    }

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> add(1527, 4728).toString() + " , using Thread : " + Thread.currentThread().getName());
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> getCharacter("GENUINE", 3).toString() + " , using Thread : " + Thread.currentThread().getName());

        CompletableFuture<?> f3
          // java.lang.ArithmeticException: / by zero
            = CompletableFuture.supplyAsync(() -> divide(18 , 0))  
                      .exceptionally(ex -> 0)
                      .thenAccept(r-> {
                        // 0 - returned by exceptionally block
                        System.out.println("Future3 Result = " + r + " , using Thread : " + Thread.currentThread().getName());
                      });

        // Running multiple tasks in parallel
        CompletableFuture<Void> allOf = CompletableFuture.allOf(f1, f2, f3);
         // Waits for all futures to complete
        allOf.join(); 

        System.out.println("Future1 Result = " + f1.get());
        System.out.println("Future2 Result = " + f2.get());
    }
}
