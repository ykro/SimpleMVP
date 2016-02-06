package edu.galileo.android.simplemvp.login;

/**
 * Created by ykro.
 */
public interface LoginPresenter {
    void onDestroy();
    void login(String email, String password);
}
