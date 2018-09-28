package netty.protocol;

/**
 * @author linlang
 * @date 2018/9/28
 */
public abstract  class Packet {

    /**
     * 协议版本
     */
    private Byte version = 1;


    public abstract Byte getCommand();

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }
}
