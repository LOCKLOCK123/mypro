package netty.protocol;

import static netty.protocol.constant.Command.LOGIN_REQUEST;
import static netty.protocol.constant.Command.LOGIN_RESPONSE;

/**
 * @author linlang
 * @date 2018/9/28
 */
public class LoginResponsePacket extends Packet {

    private boolean  success;

    private String reason;

    @Override
    public Byte getCommand() {
        return  LOGIN_RESPONSE;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
