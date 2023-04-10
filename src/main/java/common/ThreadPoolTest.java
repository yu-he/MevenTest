package common;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                for(int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    System.out.println(i);
                }
                return "完成";
            }
        });

        executorService.submit(futureTask);
        //executorService.execute(futureTask);
        System.out.println(futureTask.get());
        executorService.shutdown();
    }
}
