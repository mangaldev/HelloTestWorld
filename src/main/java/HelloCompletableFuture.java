import java.util.concurrent.*;

/**
 * Created by mdev on 5/18/16.
 */
public class HelloCompletableFuture {



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        CompletableFuture.supplyAsync(() -> takeFiveChars("Some Message"))
                .thenApplyAsync(HelloCompletableFuture::takesTime)
                .thenApply(r -> "ABC "+r)
                .thenAccept(result -> System.out.println("result = " + result));

//        for (int i = 0; i < 3; i++) {
//            String message = i+1 +"---"+UUID.randomUUID().toString();
//            CompletableFuture.supplyAsync(() -> takeFiveChars(message), executor).thenAcceptAsync(response -> System.out.println("This is complete =>>> " + response), executor);
//        }
        System.out.println("FINISHEDDDDDDDDDDD");
    }

    public static String takesTime(String message){
        System.out.println("starting timer .."+message);
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Returnign fixed String..");
        return "fixed";
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
