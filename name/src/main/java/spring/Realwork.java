package spring;

import java.util.Iterator;

/**
 * @author linlang
 * @date 2019/2/26
 */
public class Realwork implements Worker{
    @Override
    public Iterator<Worker> iterator() {
        return null;
    }

    @Override
    public Worker next() {
        return this;
    }
}
