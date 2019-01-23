package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author linlang
 * @date 2018/12/13
 */
public class Test {

    public static void main(String[] args) {
        AtomicInteger atomic = new AtomicInteger(5);
        atomic.incrementAndGet();
    }
}
