package spring;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
import spring.beans.Person;

/**
 * @author linlang
 * @date 2018/12/4
 */
public class PersonBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {

        return Person.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String name = element.getAttribute("name");
        String email = element.getAttribute("email");
        if (StringUtils.hasText(name)) {
            builder.addPropertyValue("name", name);
        }

        if (StringUtils.hasText(email)) {
            builder.addPropertyValue("email", email);
        }

    }
}
