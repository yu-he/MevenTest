package common;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //ExecutorServiceTest();
        //ExecutorServiceExceptionTest();
        ExecutorServiceCancelTest();
    }

    public static void ExecutorServiceTest() throws ExecutionException, InterruptedException {
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

        Future<?> future = executorService.submit(futureTask);
        //executorService.execute(futureTask);
        System.out.println(futureTask.get());
        executorService.shutdown();
    }

    public static void ExecutorServiceExceptionTest() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                throw new Exception("抛出异常");
            }
        });

        //Future<?> future = executorService.submit(futureTask);
        //System.out.println(future.get());
        executorService.execute(futureTask);
        System.out.println(futureTask.get());
        executorService.shutdown();
    }

    public static void ExecutorServiceCancelTest() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            for(int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println(i);
            }
            return "完成";
        });

        try {
            Future<?> future = executorService.submit(futureTask);
            futureTask.cancel(false);
            //executorService.execute(futureTask);
            String result = futureTask.get();
            System.out.println(result);
        }finally {
            executorService.shutdown();
        }
    }
}
