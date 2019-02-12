package innerClass;

/**
 * @author linlang
 * @date 2019/2/12
 */
//这个public可以去掉，表示这个类只有包访问权限；不去掉表示全局访问权限
public class OutClass {

    private String name;
    protected String date;
    public String sex;
    String weight;
    private static String nation = "China";

    /**
     * 成员内部类，把他当作一个成员就可以了，访问权限有private（只有类内部可以访问），protected类内部，一个包下的类和该类的子类可以访问，
     * public（都可以访问），默认表示一个包下的类才可以访问
     */
    class Draw {

        /**
         * 1.成员内部类可以访问外部类的所有变量，调用外部类的所有方法
         * 2.成员内部类不可以有静态方法或者静态变量
         */
        public void drawSahpe() {
            System.out.println(name);
            System.out.println(date);
            System.out.println(sex);
            System.out.println(weight);
            System.out.println(nation);
        }
    }
    //静态内部类就是一个静态变量，不依赖于外部类，因此不能引用外部类的非静态变量,关于权限的关键字只是表示这个变量或者方法对外的访问权限，不影响内部的访问
    private static class StaticDraw{
        StaticDraw(){
            System.out.println("StaticDraw");
        }
        public void drawSahpe(){
            System.out.print(nation);
        }
    }
    public void requestInnerClass(){
        StaticDraw staticDraw = new StaticDraw();
        staticDraw.drawSahpe();
    }

    public static void main(String[] args) {
        OutClass.StaticDraw staticDraw = new OutClass.StaticDraw();
        staticDraw.drawSahpe();
    }

}
