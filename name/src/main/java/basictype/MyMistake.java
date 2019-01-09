package basictype;

/**
 * @author linlang
 * @date 2019/1/8
 */
public class MyMistake extends RuntimeException{

    public MyMistake(String message, Throwable cause) {
        super(message, cause);
    }
}
