package edu.galileo.android.simplemvp.content;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.simplemvp.R;

/**
 * Created by ykro.
 */
public class ContentAdapter
        extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {
    List<String> dataSet;

    public ContentAdapter() {
        this.dataSet = new ArrayList<String>();
    }

    public void setDataSet(List<String> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String element = dataSet.get(position);
        holder.textView.setText(element);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.textView)
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
