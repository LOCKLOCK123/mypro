package initAClass;

/**
 * @author linlang
 * @date 2018/12/6
 */
public class StaticTest {
    public static void main(String[] args) {
        staticFunction();
    }

   /**
    * 静态变量的执行跟顺序有关，交换变量位置则顺序也会发生改变，不需要类执行构造函数，只会在类初次加载的时候执行一下；代码块只在构造函数执行前执行，执行异一次
   */
   {       // 实例代码块
       System.out.println("1");
   }
    static int b = 112;     // 静态变量

    static {   //静态代码块，在父类的静态代码块执行之后执行
        System.out.println(b);
    }
    private static final StaticTest st = new StaticTest();



    StaticTest() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {   // 静态方法
        System.out.println("4");
    }

    int a;    // 实例变量在，在静态代码块之后执行，在代码块和构造函数之前执行

}
