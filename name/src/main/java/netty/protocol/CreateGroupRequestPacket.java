package netty.protocol;

import java.util.List;

import static netty.protocol.constant.Command.CREATE_GROUP;
/**
 * @author linlang
 * @date 2018/11/5
 */
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP;
    }

    public List<String> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<String> userIdList) {
        this.userIdList = userIdList;
    }
}
