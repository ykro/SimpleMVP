package edu.galileo.android.simplemvp.content.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.simplemvp.R;
import edu.galileo.android.simplemvp.content.ContentPresenter;
import edu.galileo.android.simplemvp.content.ContentPresenterImpl;
import edu.galileo.android.simplemvp.content.adapters.ContentAdapter;

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
        setupRecyclerView();

        contentPresenter = new ContentPresenterImpl(this);
        contentPresenter.onCreate();
    }

    private void setupRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(contentAdapter);
    }

    @Override
    protected void onDestroy() {
        contentPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.content_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_letters:
                contentPresenter.getLetters();
                break;
            case R.id.action_numbers:
                contentPresenter.getNumbers();
                break;
            case R.id.action_names:
                contentPresenter.getNames();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setData(List<String> data) {
        contentAdapter.setDataSet(data);
    }
}
