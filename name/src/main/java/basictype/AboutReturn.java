package basictype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linlang
 * @date 2019/2/1
 */
public class AboutReturn {

    int []a = new int[]{5,6,7,8};

    public void testReturn() {
        //这个相当于（while i<=10 && a[i] <=5,执行完一次之后i变成1，再次进行判断）
        for (int i = 0; i <= 10 && a[i]<=5; i++) {
            willReturn();
            System.out.println(i);
        }
    }

    public void willReturn() {
        return;
    }

    //总结一波：finally中的代码会在try或者catch的return
    // 方法执行前执行，但是finally中无法修改返回值
    public static int makeAtrycatch(List<Integer> list){
        int x = 0;
        try {
            x++;
            //list.get(0);
            return x;
        }catch (Exception e){
            System.out.println(e);
            return 55555;
        }finally {
            x++;
            System.out.println(x);
        }

    }

    public static void main(String[] args) {
        AboutReturn aboutReturn = new AboutReturn();
        aboutReturn.testReturn();
        List<Integer> list = new ArrayList<>();
        System.out.println(makeAtrycatch(list));
        System.out.println(list);

    }
}
