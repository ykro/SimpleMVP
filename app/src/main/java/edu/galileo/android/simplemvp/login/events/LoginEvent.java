package edu.galileo.android.simplemvp.login.events;

/**
 * Created by ykro.
 */
public class LoginEvent {
    public final static int ERROR = 0;
    public final static int SUCCESS = 1;

    int type;
    String errror;

    public LoginEvent() {
    }

    public LoginEvent(int type) {
        this.type = type;
    }

    public LoginEvent(int type, String errror) {
        this.type = type;
        this.errror = errror;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getErrror() {
        return errror;
    }

    public void setErrror(String errror) {
        this.errror = errror;
    }
}
