package initAClass;

/**
 * @author linlang
 * @date 2018/12/6
 */
public class Foo {

    int i = 1;

    Foo() {
        System.out.println(i);
        //这里的getvalue（）执行的是子类的getvalue，这个涉及到重载什么。
        int x = getValue();
        System.out.println(x);
    }

    {
        i = 2;
    }

    protected int getValue() {
        return i;
    }

}
