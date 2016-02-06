package edu.galileo.android.simplemvp.login;

import android.os.AsyncTask;

import java.util.Random;

import edu.galileo.android.simplemvp.libs.EventBus;
import edu.galileo.android.simplemvp.libs.GreenRobotEventBus;

/**
 * Created by ykro.
 */
public class LoginModelImpl implements LoginModel {
    EventBus eventBus;

    public LoginModelImpl() {
        eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void login(String user, String password) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                long now = System.currentTimeMillis();
                long expectedElapsedTime = now + 1500;

                while(now < expectedElapsedTime){
                    now = System.currentTimeMillis();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Random r = new Random();
                int number = r.nextInt(10);
                LoginEvent event = new LoginEvent();
                if (number % 2 == 0) {
                    event.setType(LoginEvent.SUCCESS);
                } else {
                    event.setType(LoginEvent.ERROR);
                    event.setErrror("falló");
                }

                eventBus.post(event);
            }
        }.execute();
    }
}
