package info.alexandertyler.androidtrials.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.alexandertyler.androidtrials.adapters.TrialAdapter;
import info.alexandertyler.androidtrials.R;
import info.alexandertyler.androidtrials.data.TrialData;

/**
 * Created by Alex on 1/28/2017.
 */

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.main_recycler)
    RecyclerView recycler;

    private TrialAdapter trialAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // set up the toolbar to be our action bar
        setSupportActionBar(toolbar);

        // hardcoded list of trials for now
        List<TrialData> trialDataList = new ArrayList<>();

        // custom hash map implementation
        TrialData data = new TrialData("HashMap", HashMapActivity.class);
        trialDataList.add(data);

        // linked list
        data = new TrialData("Linked List", LinkedListActivity.class);
        trialDataList.add(data);


        trialAdapter = new TrialAdapter(trialDataList);
        recycler.setAdapter(trialAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recycler.setLayoutManager(llm);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
