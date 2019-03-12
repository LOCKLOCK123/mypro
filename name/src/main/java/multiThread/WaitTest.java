package multiThread;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
            notifyAll();
        }

        synchronized int get() throws InterruptedException {
            // line 0
            if (list.size() == 0) {  // line 1//这里如果用if的话只会判断一次，阻塞之后如果再次被唤醒就会进入line3然后用if的话会继续执行，但是用while就会再判断一次
                wait();  // line2
                // line 3
            }
            int v = list.remove(0);  // line 4
            notifyAll(); // line 5
            return v;
        }

        synchronized int size() {
            return list.size();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        final Buf buf = new Buf();
        ExecutorService es = Executors.newFixedThreadPool(11);
        for (int i = 0; i < 1; i++) {
            es.execute(new Runnable() {

                @Override
                public void run() {
                    //这个线程会一直跑知道出错为止
                    while (true) {
                        try {
                            buf.put(1);
                            //Thread.sleep(20);
                            System.out.println(Thread.currentThread().getName() + " is finished");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            });
        }
        for (int i = 0; i < 1; i++) {
            es.execute(new Runnable() {

                @Override
                public void run() {
                    while (true ) {
                        try {
                            buf.get();
                            System.out.println(Thread.currentThread().getName()+" is finished");
                            //sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
                            //但是他的监控状态依然保持着，当指定的时间到了又会自动恢复运行状态。
                            //在调用sleep()方法的过程中，线程不会释放对象锁，就是这里的buf对象。
                            //Thread.sleep(10);
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
        //es.awaitTermination(2, TimeUnit.SECONDS);

    }
}
