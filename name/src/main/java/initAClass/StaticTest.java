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
    * 静态变量的执行跟顺序有关，交换变量位置则顺序也会发生改变；代码块只在构造函数执行前执行，执行异一次
   */
   {       // 实例代码块
       System.out.println("2");
   }
    static int b = 112;     // 静态变量

    static {   //静态代码块
        System.out.println("1");
    }
   // private static final StaticTest st = new StaticTest();




    StaticTest() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {   // 静态方法
        System.out.println("4");
    }

    int a = 110;    // 实例变量

}
