package generic;

import java.util.Collection;

/**
 * @author linlang
 * @date 2019/1/24
 * @Description: 关于泛型的学习
 */
public class Cache<T> {

    T value;
    private  Object[] elementData = new Object[8];

    public Object getValue() {
        return elementData[0];
    }

    public void setValue(T value) {
        this.value = value;
    }
    public  <E> void testMethod(E e){
    }

    public  <A> A testMethod1(A t){
        return t;
    }

    public boolean add(T e) {
        elementData[0] = e;
        return true;
    }

    public <T> void test(T t, Collection<T> collection){

    }

    public void testWildCards(Collection<T> collection){
        /**
         * 有人说，<?>提供了只读的功能，也就是它删减了增加具体类型元素的能力，只保留与具体类型无关的功能。
         * 它不管装载在这个容器内的元素是什么类型，它只关心元素的数量、容器是否为空？我想这种需求还是很常见的吧。
         */

    }




    public static void main(String[] args) {
        Cache<Integer> cache = new Cache<>();
        cache.add(1);
        System.out.print(cache.getValue());
    }


}
