package basictype;

/**
 * @author linlang
 * @date 2018/9/30
 */
public class BasicTypeTest {

    public static void main(String[] args) {
        int i = 1;
        System.out.println("i++ = " + (i++));
        System.out.println("++i = " + (++i));
        Integer integer = 1;
        Double d = 1d;//Double的valueof方法直接返回一个新的Doube，用==比较肯定是false
        Integer integer1 = 1;//>-128 <128返回缓存里的 否则返回一个新的
        short s2 = 100;
        Short s1 = 100;//自动装箱
        Short s = Short.valueOf(s1); // 只能从短的往长的转，从精度低的往精度高的转，在这里是在自动拆箱
        Long l1 = 100L; //>-128 <128返回缓存里的 否则返回一个新的
        long l2 = 10;
        double b = 10;
        float f = 2.5f;

        System.out.println(integer == i);

        System.out.println(d );
    }
}
