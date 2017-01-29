package info.alexandertyler.androidtrials.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import info.alexandertyler.androidtrials.R;
import info.alexandertyler.androidtrials.data.TrialData;
import info.alexandertyler.androidtrials.viewholders.BaseViewHolder;
import info.alexandertyler.androidtrials.viewholders.TrialViewHolder;

/**
 * Created by Alex on 1/28/2017.
 */

public class TrialAdapter extends BaseAdapter<TrialData> {

    private static final String TAG = "TrialAdapter";

    public TrialAdapter(List<TrialData> mData) {
        super(mData);
    }

    @Override
    public TrialViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.trial_row, parent, false);
        TrialViewHolder holder = new TrialViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        TrialViewHolder trialHolder = (TrialViewHolder) holder;
        final TrialData currItem = mData.get(position);
        trialHolder.trialTitle.setText(currItem.name);

        trialHolder.trialTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), currItem.activity);
                v.getContext().startActivity(intent);
                // don't finish the activity because we want to go back to the main activity easily
            }
        });
    }
}
