package im_common;

public interface MessageType {
    String LOGIN_SUCCEED = "1";
    String LOGIN_FAIL = "2";
    String COMM_MES = "3"; // common message
    String GET_ONLINE_USER = "4";
    String RETURN_ONLINE_USER = "5";
    String SERVER_EXIT = "6";
    String CLIENT_EXIT = "7";
}
