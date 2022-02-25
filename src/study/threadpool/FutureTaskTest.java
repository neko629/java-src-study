package study.threadpool;

import java.util.concurrent.FutureTask;

/**
 * 2 * @Author: Crimson
 * 3 * @Date: 2022/2/25 22:21
 * 4
 */
public class FutureTaskTest {

    public static void main(String[] args) throws Exception{
        FutureTask ft = new FutureTask(() -> {
            Thread.sleep(5000l);
            return 2;
        });
        Thread t = new Thread(ft);
        t.start();
        for (int i = 1; i < 10; i++) {
            Thread.sleep(1000l);
            if (i == 6) {
                System.out.println(ft.get());
            }
            System.out.println(ft.isDone());
        }
    }
}
