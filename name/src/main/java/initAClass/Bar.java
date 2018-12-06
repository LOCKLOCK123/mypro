package initAClass;

/**
 * @author linlang
 * @date 2018/12/6
 */
public class Bar extends Foo {
    int j = 1;

    Bar() {
        j = 2;
    }

    {
        j = 3;
    }

    @Override
    protected int getValue() {
        return j;
    }


}
