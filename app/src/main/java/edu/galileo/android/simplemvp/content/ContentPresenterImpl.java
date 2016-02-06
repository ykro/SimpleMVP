package edu.galileo.android.simplemvp.content;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.simplemvp.content.events.ContentEvent;
import edu.galileo.android.simplemvp.content.ui.ContentView;
import edu.galileo.android.simplemvp.libs.EventBus;
import edu.galileo.android.simplemvp.libs.GreenRobotEventBus;

/**
 * Created by ykro.
 */
public class ContentPresenterImpl implements ContentPresenter  {
    ContentView view;
    EventBus eventBus;

    public ContentPresenterImpl(ContentView view) {
        this.view = view;
        eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void getNames() {
        NamesInteractor interactor = new NamesInteractorImpl();
        interactor.getNames();
    }

    @Override
    public void getLetters() {
        LettersInteractor interactor = new LettersInteractorImpl();
        interactor.getLetters();
    }

    @Override
    public void getNumbers() {
        NumbersInteractor interactor = new NumbersInteractorImpl();
        interactor.getNumbers();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        this.view = null;
        eventBus.unregister(this);
    }

    @Override
    @Subscribe
    public void onEventMainThread(ContentEvent event) {
        if (this.view != null) {
            view.setData(event.getData());
        }
    }
}
