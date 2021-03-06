package edu.galileo.android.simplemvp.login;

/**
 * Created by ykro.
 */
public interface LoginView {
    void enableInputs();
    void disableInputs();

    void showProgress();
    void hideProgress();

    void successLogin();
    void failedLogin(String error);
}
