package netty.protocol;

import java.util.List;
import static netty.protocol.constant.Command.GROUP_SUCCESS;


/**
 * @author linlang
 * @date 2018/11/5
 */
public class CreateGroupResponsePacket extends Packet{

    private Boolean success;
    private List<String> usernameList;
    private String groupId;


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<String> getUsernameList() {
        return usernameList;
    }

    public void setUsernameList(List<String> usernameList) {
        this.usernameList = usernameList;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public Byte getCommand() {
        return GROUP_SUCCESS;
    }
}
