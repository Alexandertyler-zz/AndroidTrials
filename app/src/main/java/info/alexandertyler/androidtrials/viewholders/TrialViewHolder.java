package info.alexandertyler.androidtrials.viewholders;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.alexandertyler.androidtrials.R;

/**
 * Created by Alex on 1/28/2017.
 */

public class TrialViewHolder extends BaseViewHolder {

    @BindView(R.id.trial_row_title)
    public TextView trialTitle;


    public TrialViewHolder(View itemView) {
        super(itemView);
    }



}
