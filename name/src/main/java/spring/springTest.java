package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.beans.Person;

/**
 * @author linlang
 * @date 2018/12/4
 */
public class springTest {


    public static void main(String[] args) {
        ApplicationContext beans=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person user=(Person) beans.getBean("2123");
        System.out.println("username:"+user.getName()+":"+"email:"+user.getEmail());

    }

}
