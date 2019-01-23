package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.factorymodel.Car;
import spring.setUsage.Person;

/**
 * @author linlang
 * @date 2018/12/4
 */
public class springTest {


    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        Car car1 = (Car) ctx.getBean("car4");

        System.out.println(car1);

        car1 = (Car) ctx.getBean("car6");

        System.out.println(car1);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

        Person person1 = (Person) ctx.getBean("person2");
        System.out.println(person1);




    }

}
