package edu.galileo.android.simplemvp.login;

import edu.galileo.android.simplemvp.login.events.LoginEvent;

/**
 * Created by ykro.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(LoginEvent event);
    void login(String email, String password);
}
