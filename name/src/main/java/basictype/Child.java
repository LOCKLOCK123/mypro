package basictype;

import io.netty.channel.Channel;

/**
 * @author linlang
 * @date 2018/11/22
 */
public class Child extends  Father{


    public static void main(String[] args) {
       Father father = new Child();
        father.say();
    }

    @Override
    public void say() {
        System.out.println("I'm child");
    }
}
