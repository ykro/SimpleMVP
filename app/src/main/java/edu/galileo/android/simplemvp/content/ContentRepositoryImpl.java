package edu.galileo.android.simplemvp.content;

import java.util.Arrays;

import edu.galileo.android.simplemvp.content.events.ContentEvent;
import edu.galileo.android.simplemvp.libs.EventBus;
import edu.galileo.android.simplemvp.libs.GreenRobotEventBus;

/**
 * Created by ykro.
 */
public class ContentRepositoryImpl implements ContentRepository {
    EventBus eventBus;

    private static class SingletonHolder {
        private static final ContentRepositoryImpl INSTANCE = new ContentRepositoryImpl();
    }

    public static ContentRepositoryImpl getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public ContentRepositoryImpl() {
        eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void getNumbers() {
        String[] data = {"uno", "dos", "tres"};
        ContentEvent event = new ContentEvent();
        event.setData(Arrays.asList(data));
        eventBus.post(event);
    }

    @Override
    public void getLetters() {
        String[] data = {"a", "b", "c"};
        ContentEvent event = new ContentEvent();
        event.setData(Arrays.asList(data));
        eventBus.post(event);
    }

    @Override
    public void getNames() {
        String[] data = {"Hugo", "Paco", "Luis"};
        ContentEvent event = new ContentEvent();
        event.setData(Arrays.asList(data));
        eventBus.post(event);
    }
}
