package spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author linlang
 * @date 2018/12/4
 */
public class MyUserNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("person",new PersonBeanDefinitionParser());
    }
}
