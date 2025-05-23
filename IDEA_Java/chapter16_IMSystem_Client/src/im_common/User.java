package im_common;

import java.io.Serializable;

// User information
public class User implements Serializable {
    private String id;
    private String pwd;
    private static final long serialVersion = 1l;

    public User() {
    }

    public User(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
