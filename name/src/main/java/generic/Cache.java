package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author linlang
 * @date 2019/1/24
 * @Description: 关于泛型的学习
 */
public class Cache<T> {

    T value;

    public Object getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public  <E> void testMethod(E e){
    }

    public  <A> A  testMethod1(A t){
        return t;
    }

    public <T> void test(T t, Collection<T> collection){

    }

    public void testWildCards(Collection<?> collection){
        /**
         * 有人说，<?>提供了只读的功能，也就是它删减了增加具体类型元素的能力，只保留与具体类型无关的功能。
         * 它不管装载在这个容器内的元素是什么类型，它只关心元素的数量、容器是否为空？我想这种需求还是很常见的吧。
         */

    }




    public static void main(String[] args) {
        Cache<String> cache = new Cache<>();
        cache.setValue("2333");
        System.out.println(cache.getValue());
        cache.testMethod(1);
        List<String> strings = new ArrayList<>();
        cache.test("2333", strings);
        cache.testWildCards(strings);
    }


}
