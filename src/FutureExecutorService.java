import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExecutorService {
    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static Integer increment(int i, int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (i <= n) {
            i++;
        }
        return i;
    }

    private static String getSubstring(String str, int start, int end) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return str.substring(start, end);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future1 = executorService.submit(() -> "Incremented Value = " + increment(0, 9).toString()
                + " , Task1 is done by Thread : " + Thread.currentThread().getName());
        System.out.println(future1.get());

        Future<String> future2 = executorService.submit(() -> "Substring Result = " + getSubstring("Delicious!", 2, 9)
                + " , Task2 is done by Thread : " + Thread.currentThread().getName());
        System.out.println(future2.get());
        Future<?> future3 = executorService.submit(() -> {
            System.out.println("Factorial Result = " + factorial(6));
            System.out.println("Task3 is done by Thread : " + Thread.currentThread().getName());
        });
        future3.get();

        executorService.shutdown();
    }

}
