package info.alexandertyler.androidtrials.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;


/**
 * Created by Alex on 1/28/2017.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    protected View itemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }
}
