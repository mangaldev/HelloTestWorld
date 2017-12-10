package future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFuture1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return something();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });
        System.out.println("Next Line reached ...Now give some time to finish future ..");
        TimeUnit.SECONDS.sleep(1);
        stringCompletableFuture.get();
        System.out.println("FINISHED");
    }

    private static  String something() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Sleeping ...");
        }
        return "something";
    }
}
