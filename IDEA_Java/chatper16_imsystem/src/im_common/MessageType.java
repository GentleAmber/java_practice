package im_common;

public interface MessageType {
    String LOGIN_SUCCEED = "1";
    String LOGIN_FAIL = "2";
    String COMM_MES = "3"; // common message
    String COMM_MES_SENT_SUCCEED = "3.1"; // for server to tell the client that the message it
                                        // attempted to send was sent successfully
    String COMM_MES_SENT_FAIL = "3.2";
    String GET_ONLINE_USER = "4";
    String RETURN_ONLINE_USER = "5";
    String SERVER_EXIT = "6";
    String CLIENT_EXIT = "7";
}
