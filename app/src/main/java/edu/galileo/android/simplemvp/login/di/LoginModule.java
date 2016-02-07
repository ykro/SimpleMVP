package edu.galileo.android.simplemvp.login.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.simplemvp.libs.EventBus;
import edu.galileo.android.simplemvp.login.LoginModel;
import edu.galileo.android.simplemvp.login.LoginModelImpl;
import edu.galileo.android.simplemvp.login.LoginPresenter;
import edu.galileo.android.simplemvp.login.LoginPresenterImpl;
import edu.galileo.android.simplemvp.login.ui.LoginView;

/**
 * Created by ykro.
 */
@Module
public class LoginModule {
    LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    LoginPresenter provideLoginPresenter(LoginView view, LoginModel model, EventBus eventBus) {
        return new LoginPresenterImpl(view, model, eventBus);
    }

    @Provides
    @Singleton
    LoginView provideLoginView() {
        return this.view;
    }

    @Provides
    @Singleton
    LoginModel provideLoginModel(EventBus eventBus) {
        return new LoginModelImpl(eventBus);
    }
}
