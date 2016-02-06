package edu.galileo.android.simplemvp.login;

/**
 * Created by ykro.
 */
public interface LoginTaskListener {
    void loginSuccess();
    void loginError(String error);
}
