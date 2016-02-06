package edu.galileo.android.simplemvp.content;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.simplemvp.R;

public class ContentActivity extends AppCompatActivity
implements ContentView {
    @Bind(R.id.recycler)
    RecyclerView recyclerView;

    ContentAdapter contentAdapter;
    ContentPresenter contentPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        ButterKnife.bind(this);

        contentAdapter = new ContentAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(contentAdapter);

        ContentModel model = new ContentModelImpl();
        contentPresenter = new ContentPresenterImpl(this, model);
        contentPresenter.getData();
    }

    @Override
    protected void onDestroy() {
        contentPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setData(List<String> data) {
        contentAdapter.setDataSet(data);
    }
}
