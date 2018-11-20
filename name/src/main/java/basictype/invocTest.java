package basictype;

import changhai3.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author linlang
 * @date 2018/11/20
 */
public class invocTest {

     public  void  age(int age){
         System.out.println("int age=" +age);
     }

    public  void  age(Integer age){
        System.out.println("integer age=" +age);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        invocTest obj = new invocTest();
        Method method = obj.getClass().getMethod("age", Integer.TYPE);

        method.invoke(obj,new Integer(27));
        method.invoke(obj,27);

        Method method1 = obj.getClass().getMethod("age", Integer.TYPE);
        method1.invoke(obj,new Integer(28));
        method1.invoke(obj,28);
    }




}
