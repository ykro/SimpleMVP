package edu.galileo.android.simplemvp.login;

/**
 * Created by ykro.
 */
public class LoginPresenterImpl implements LoginPresenter,
                                            LoginTaskListener {
    LoginView view;
    LoginModel model;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        this.model = new LoginModelImpl(this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void login(String email, String password) {
        if (this.view != null) {
            view.disableInputs();
            view.showProgress();
            model.login(email, password);
        }
    }

    @Override
    public void loginSuccess(){
        if (this.view != null) {
            view.enableInputs();
            view.hideProgress();
            view.successLogin();
        }
    }

    @Override
    public void loginError(String error) {
        if (this.view != null) {
            view.enableInputs();
            view.hideProgress();
            view.failedLogin(error);
        }
    }
}
