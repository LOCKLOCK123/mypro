package spring.setUsage;

/**
 * @author linlang
 * @date 2019/1/23
 */
public class Person {
    private String name;
    private Integer id;

   /* 所以如果无参构造函数不存在，Spring上下文创建对象的时候便会报错。*/
    public Person() {
    }

    public Person(String name, Integer id) {
        super();
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", id=" + id + "]";
    }

}
