package innerClass;

/**
 * @author linlang
 * @date 2019/1/25
 * @Description:一个观察者模式, 使用匿名内部类实现
 */
public class ThisAButton {

    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    private void notifyAllListener(String name) {
        listener.hearTheEvent(name);
    }

    public void beTouched() {
        System.out.println("DO NOT TOUCH ME");
        if (listener != null) {
            notifyAllListener("Hentai A");
        }
    }

    public static void main(String[] args) {
        ThisAButton thisAButton = new ThisAButton();
        thisAButton.setListener(new Listener() {
            @Override
            public String hearTheEvent(String name) {
                System.out.println(name);
                System.out.println("I'm listener, I'll call the police");
                return name;
            }
        });
        thisAButton.beTouched();
    }
}
