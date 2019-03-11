package spring.beanactory;

/**
 * @author linlang
 * @date 2019/1/28
 */
public class SimpleBean {

    private String conectionString;
    private String name;
    private String passWord;

    public String getConectionString() {
        return conectionString;
    }

    public void setConectionString(String conectionString) {
        this.conectionString = conectionString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "conectionString='" + conectionString + '\'' +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
