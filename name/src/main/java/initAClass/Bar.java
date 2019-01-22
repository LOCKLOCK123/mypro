package initAClass;

/**
 * @author linlang
 * @date 2018/12/6
 */
public class Bar extends Foo {
    int j = 1;

    Bar() {

    }
    //代码块在构造函数执行之前执行
    {
        j = 3;
    }

    @Override
    protected int getValue() {
        return j;
    }


}
