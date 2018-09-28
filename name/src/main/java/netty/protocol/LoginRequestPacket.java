package netty.protocol;

import static netty.protocol.constant.Command.LOGIN_REQUEST;

/**
 * @author linlang
 * @date 2018/9/28
 */
public class LoginRequestPacket extends  Packet{

    private Integer userId;

    private String username;

    private String password;


    @Override
    public Byte getCommand() {
        return  LOGIN_REQUEST;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
