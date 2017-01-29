package info.alexandertyler.androidtrials.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import info.alexandertyler.androidtrials.viewholders.BaseViewHolder;

/**
 * Created by Alex on 1/28/2017.
 */

public class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    protected List<T> mData;

    public BaseAdapter(List<T> data) {
        mData = data;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        // set up the views here
    }

    @Override
    public int getItemCount() {
        if (mData != null) return mData.size();
        return 0;
    }
}
