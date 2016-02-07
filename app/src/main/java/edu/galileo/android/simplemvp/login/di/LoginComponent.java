package edu.galileo.android.simplemvp.login.di;

import javax.inject.Singleton;

import dagger.Component;
import edu.galileo.android.simplemvp.libs.di.LibsModule;
import edu.galileo.android.simplemvp.login.LoginPresenter;
import edu.galileo.android.simplemvp.login.ui.LoginActivity;

/**
 * Created by ykro.
 */
@Singleton
@Component(modules = {LoginModule.class, LibsModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
    LoginPresenter getPresenter();
}
