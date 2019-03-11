package spring.beanactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

/**
 * @author linlang
 * @date 2019/1/28
 */
public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

    private Set<String> obscenties;


    public ObscenityRemovingBeanFactoryPostProcessor() {
        this.obscenties = new HashSet<>();
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for(String beanName : beanNames){
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            StringValueResolver valueResolver = new StringValueResolver() {
                @Override
                public String resolveStringValue(String s) {
                    if(isObscenity(s)) {return "****";}
                    return s;
                }
            };
            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
            visitor.visitBeanDefinition(beanDefinition);
        }

    }

    private boolean isObscenity(Object value){
        String potential = value.toString().toUpperCase();
        return this.obscenties.contains(potential);
    }

    public  void  setObscenties(Set<String> obscenties){
        this.obscenties.clear();
        for (String obs:obscenties){
            this.obscenties.add(obs.toUpperCase());
        }
    }


}
