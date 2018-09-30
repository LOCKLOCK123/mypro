package netty.protocol;

import static netty.protocol.constant.Command.MESSAGE_RESPONSE;

/**
 * @author linlang
 * @date 2018/9/30
 */
public class MessageResponsePacket extends Packet{

    private  String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
