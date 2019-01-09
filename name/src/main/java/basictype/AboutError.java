package basictype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linlang
 * @date 2018/11/22
 */
public class AboutError {

    public static void main(String[] args) {
        for (int k = 0; k<10;k++){
            getError();
        }
    }
    /**
     * 关于异常，如果希望抛出异常之后代码继续执行，则应该将可能报错的部分进行包裹，并且做好默认值的处理；
     * 如果不希望继续执行，则应该将全部代码都进行包裹；
     * 异常如果被调用的函数自己不catch，就会一直向上抛出，直至报错；
     *
     * */
    public static void getError(){
            List<Integer> list = new ArrayList<>();
            try {
                list.get(0);
            }catch (Exception e){
                throw new MyMistake("someThing happen",e);
            }
            System.out.println("23333");
    }
}
