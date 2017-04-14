import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by mdev on 5/18/16.
 */
public class HelloCompletableFuture {



    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 3; i++) {
            String message = i+1 +"---"+UUID.randomUUID().toString();
            CompletableFuture.supplyAsync(() -> takeFiveChars(message), executor).thenAcceptAsync(response -> System.out.println("This is complete =>>> " + response), executor);
        }
        System.out.println("FINISHEDDDDDDDDDDD");
    }

    private static String takeFiveChars(String message) {
        System.out.println("message = [" + message + "]");
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String substring = message.toUpperCase().substring(0, 10);
        System.out.println("substring = " + substring);
        return substring;
    }
}
