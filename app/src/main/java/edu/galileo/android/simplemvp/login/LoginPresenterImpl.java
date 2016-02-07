package edu.galileo.android.simplemvp.login;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.simplemvp.libs.EventBus;
import edu.galileo.android.simplemvp.login.events.LoginEvent;
import edu.galileo.android.simplemvp.login.ui.LoginView;

/**
 * Created by ykro.
 */
public class LoginPresenterImpl implements LoginPresenter {
    LoginView view;
    LoginModel model;
    EventBus eventBus;

    public LoginPresenterImpl(LoginView view, LoginModel model, EventBus eventBus) {
        this.view = view;
        this.model = model;
        this.eventBus = eventBus;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        view = null;
        eventBus.unregister(this);
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
    @Subscribe
    public void onEventMainThread(LoginEvent event){
        if (this.view != null) {
            view.enableInputs();
            view.hideProgress();
        }

        if (event.getType() == LoginEvent.SUCCESS) {
            view.successLogin();
        } else if (event.getType() == LoginEvent.ERROR){
            view.failedLogin(event.getErrror());
        }
    }
}
