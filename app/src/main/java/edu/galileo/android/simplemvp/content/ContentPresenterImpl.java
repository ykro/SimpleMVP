package edu.galileo.android.simplemvp.content;

import java.util.List;

/**
 * Created by ykro.
 */
public class ContentPresenterImpl implements ContentPresenter, ContentTaskListener  {
    ContentView view;
    ContentModel model;

    public ContentPresenterImpl(ContentView view, ContentModel model) {
        this.view = view;
        this.model = model;
    }


    @Override
    public void getData() {
        model.getData(this);
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

    @Override
    public void onData(List<String> data) {
        if (this.view != null) {
            view.setData(data);
        }
    }
}
