package edu.galileo.android.simplemvp.content;

import java.util.Arrays;

/**
 * Created by ykro.
 */
public class ContentModelImpl implements ContentModel {
    @Override
    public void getData(ContentTaskListener listener) {
        String[] data = {"uno", "dos", "tres"};
        listener.onData(Arrays.asList(data));
    }
}
