package edu.galileo.android.simplemvp.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.galileo.android.simplemvp.R;
import edu.galileo.android.simplemvp.content.ui.ContentActivity;
import edu.galileo.android.simplemvp.libs.EventBus;
import edu.galileo.android.simplemvp.libs.di.LibsModule;
import edu.galileo.android.simplemvp.login.LoginModel;
import edu.galileo.android.simplemvp.login.LoginPresenter;
import edu.galileo.android.simplemvp.login.di.DaggerLoginComponent;
import edu.galileo.android.simplemvp.login.di.LoginModule;


public class LoginActivity extends AppCompatActivity implements LoginView {
    @Bind(R.id.email) EditText inputEmail;
    @Bind(R.id.password) EditText inputPassword;
    @Bind(R.id.email_sign_in_button) Button buttonSubmit;
    @Bind(R.id.login_progress) ProgressBar progressBar;

    @Inject EventBus eventBus;
    @Inject LoginModel model;
    @Inject LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        /*
        EventBus eventBus = GreenRobotEventBus.getInstance();
        LoginModel model = new LoginModelImpl(eventBus);
        presenter = new LoginPresenterImpl(this, model, eventBus);
        */
        setupInjection();
        presenter.onCreate();
    }

    private void setupInjection() {
        //LoginComponent loginComponent =
        DaggerLoginComponent
                .builder()
                .libsModule(new LibsModule())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);

        //presenter = loginComponent.getPresenter();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @OnClick(R.id.email_sign_in_button)
    public void login(){
        presenter.login(inputEmail.getText().toString(),
                        inputPassword.getText().toString());
    }

    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void disableInputs() {
        setInputs(false);
    }

    private void setInputs(boolean enabled){
        inputEmail.setEnabled(enabled);
        inputPassword.setEnabled(enabled);
        buttonSubmit.setEnabled(enabled);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void successLogin() {
        startActivity(new Intent(this, ContentActivity.class));
    }

    @Override
    public void failedLogin(String error) {
        if (error != null && !error.isEmpty()) {
            inputEmail.setError(error);
        }
    }
}

