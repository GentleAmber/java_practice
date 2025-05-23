package second_try.common;

import java.io.Serializable;

public interface MessageType extends Serializable {
    String VERIFICATION_SUCCESS = "1";
    String VERIFICATION_FAIL = "2";
    String USER_NOT_EXIST = "3";
    String CLIENT_REQUEST_EXIT = "4";
    String SERVER_REQUEST_EXIT = "5";
    String REQUEST_ONLINE_USER_LIST = "6";
    String CLIENT_CAN_EXIT = "7";
    String MESSAGE_TO_ALL ="8";
    String MESSAGE_FROM_OTHER_CLIENT = "9";


}
