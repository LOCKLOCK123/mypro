package netty.protocol;

import static netty.protocol.constant.Command.MESSAGE_RESPONSE;

/**
 * @author linlang
 * @date 2018/9/30
 */
public class MessageResponsePacket extends Packet {

    private String fromUserId;
    private String message;
    private String fromUserName;

    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }
}
