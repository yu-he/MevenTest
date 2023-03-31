package ArtConcurrentBook.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * 6-4
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ignored) {
            System.out.println("线程" + Thread.currentThread().getName() + "抛出中断异常");
        }
    }
}
