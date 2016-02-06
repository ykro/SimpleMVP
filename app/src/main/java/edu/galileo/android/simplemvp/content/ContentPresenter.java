package edu.galileo.android.simplemvp.content;

import edu.galileo.android.simplemvp.content.events.ContentEvent;

/**
 * Created by ykro.
 */
public interface ContentPresenter {
    void getLetters();
    void getNumbers();
    void getNames();
    void onCreate();
    void onDestroy();
    void onEventMainThread(ContentEvent event);
}
