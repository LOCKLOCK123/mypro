package netty.protocol;

/**
 * @author linlang
 * @date 2018/9/28
 */
public class LoginResponsePacket extends Packet {

    private boolean  success;

    private String reason;

    @Override
    public Byte getCommand() {
        return null;
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
