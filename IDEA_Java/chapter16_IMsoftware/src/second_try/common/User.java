package second_try.common;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String pwd;

    public User(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public User() {
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

    @Override
    public String toString() {
        return "User " + id;
    }
}
