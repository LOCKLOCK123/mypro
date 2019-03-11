package spring;

/**
 * @author linlang
 * @date 2019/2/26
 */
public interface Worker extends Boss {

    @Override
    Worker next();

}
