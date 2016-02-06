package edu.galileo.android.simplemvp.content.events;

import java.util.List;

/**
 * Created by ykro.
 */
public class ContentEvent {
    List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
