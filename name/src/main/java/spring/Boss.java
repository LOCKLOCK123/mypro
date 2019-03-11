package spring;

import java.util.Iterator;

/**
 * @author linlang
 * @date 2019/2/26
 */
public interface Boss extends Iterable<Worker>{

    @Override
     Iterator<Worker> iterator();



    Worker next();



}
