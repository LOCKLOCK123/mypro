package spring.beanactory;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author linlang
 * @date 2019/1/28
 */
public class testBeanPostProcessor {

    public static void main(String[] args) {
        ConfigurableListableBeanFactory beanFactory  = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        BeanFactoryPostProcessor bf = (BeanFactoryPostProcessor) beanFactory.getBean("bfapp");
        bf.postProcessBeanFactory(beanFactory);
        System.out.println(beanFactory.getBean("simpleBean"));
    }
}
