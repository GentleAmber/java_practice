package im_common;

public interface MessageType {
    String LOGIN_SUCCEED = "1";
    String LOGIN_FAIL = "2";
    String COMM_MES = "3"; // common message
    String COMM_MES_TO_ALL = "3.1";
    String COMM_MES_SENT_SUCCEED = "3.2"; // for server to tell the client that the message it
                                        // attempted to send was sent successfully.
    String COMM_MES_SENT_FAIL = "3.3";
    String COMM_MES_STORED_IN_SERVER = "3.4";// Server will deliver these messages once
                                            // the receiver is online.
    String GET_ONLINE_USER = "4";
    String RETURN_ONLINE_USER = "5";
    String SERVER_EXIT = "6";
    String CLIENT_EXIT = "7";
    String SEND_FILE = "8";
    String FILE_SENT_SUCCEED = "8.1";
    String FILE_SENT_FAIL = "8.2";
}
