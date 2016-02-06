package edu.galileo.android.simplemvp.login;

import java.util.Random;

/**
 * Created by ykro.
 */
public class LoginModelImpl implements LoginModel {
    LoginTaskListener listener;

    public LoginModelImpl(LoginTaskListener listener) {
        this.listener = listener;
    }

    @Override
    public void login(String user, String password) {
        new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    listener.loginSuccess();

                    Random r = new Random();
                    int number = r.nextInt()*10000;
                    if (number % 2 == 0) {
                        listener.loginSuccess();
                    } else {
                        listener.loginError("falló");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.run();
    }
}
