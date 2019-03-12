package multiThread;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author linlang
 * @date 2019/3/12
 * 关于wait使用方式详解
 */
public class WaitTest {
    static class Buf {
        private final int MAX = 5;
        private final ArrayList<Integer> list = new ArrayList<>();
        synchronized void put(int v) throws InterruptedException {
            if (list.size() == MAX) {
                wait();
            }
            list.add(v);
            notify();
        }

        synchronized int get() throws InterruptedException {
            // line 0
            if (list.size() == 0) {  // line 1//这里如果用if的话只会判断一次，阻塞之后如果再次被唤醒就会进入line3然后用if的话会继续执行，但是用while就会再判断一次
                wait();  // line2
                // line 3
            }
            int v = list.remove(0);  // line 4
            notify(); // line 5
            return v;
        }

        synchronized int size() {
            return list.size();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        final Buf buf = new Buf();
        ExecutorService es = Executors.newFixedThreadPool(11);
        for (int i = 0; i < 1; i++)
            es.execute(new Runnable() {

                @Override
                public void run() {
                    while (true ) {
                        try {
                            buf.put(1);
                            Thread.sleep(20);
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            });
        for (int i = 0; i < 1; i++) {
            es.execute(new Runnable() {

                @Override
                public void run() {
                    while (true ) {
                        try {
                            buf.get();
                            Thread.sleep(10);
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            });
        }

        es.shutdown();
        es.awaitTermination(1, TimeUnit.DAYS);

    }
}
