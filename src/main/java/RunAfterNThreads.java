public class RunAfterNThreads {
//    public static void main(String[] args) {
//        CompletableFuture.runAsync().thenCompose().thenAccept().thenApply()
//
//    }
////    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        final CompletableFuture<Object> objectCompletableFuture = CompletableFuture.supplyAsync(RunAfterNThreads::runFirstBatchOfThreads)
//                .thenApply((t) -> runSecondBatchOfThreads(null)).thenApply();
//        final CompletableFuture<Object> objectCompletableFuture1 = CompletableFuture.supplyAsync(RunAfterNThreads::runFirstBatchOfThreads)
//                .thenCompose(RunAfterNThreads::runSecondBatchOfThreadss).thenApply();
//    }
//
//    private static <U> CompletionStage<U> runSecondBatchOfThreadss(String t) {
//        return null;
//    }
//
//    private static String runSecondBatchOfThreads(String o) {
//        return null;
//    }
//
//
//    private static String runFirstBatchOfThreads() {
//        return null;
//    }
}
