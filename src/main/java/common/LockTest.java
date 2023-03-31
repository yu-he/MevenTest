package common;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        final int[] counter = {0};
        ReentrantLock lock = new ReentrantLock();

        for (int i= 0; i < 10; i++){
            new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(5000);
                    int a = counter[0];
                    counter[0] = a + 1;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
                System.out.println(counter[0]);
            }).start();
        }

        // 主线程休眠，等待结果
        Thread.sleep(15000);
        System.out.println(counter[0]);
    }
}
