package netty.protocol;

import static netty.protocol.constant.Command.MESSAGE_REQUEST;

/**
 * @author linlang
 * @date 2018/9/30
 */
public class MessageRequestPacket extends  Packet{

    private String message;

    public MessageRequestPacket(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
