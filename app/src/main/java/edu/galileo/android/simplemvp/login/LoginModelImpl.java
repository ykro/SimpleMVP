package edu.galileo.android.simplemvp.login;

import android.os.AsyncTask;
import android.util.Log;

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
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                long now = System.currentTimeMillis();
                long expectedElapsedTime = now + 5000;
                Log.e("MSG",now + " " + expectedElapsedTime);

                while(now < expectedElapsedTime){
                    now = System.currentTimeMillis();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Random r = new Random();
                int number = r.nextInt()*10000;
                if (number % 2 == 0) {
                    listener.loginSuccess();
                } else {
                    listener.loginError("falló");
                }
            }
        }.execute();
    }
}
