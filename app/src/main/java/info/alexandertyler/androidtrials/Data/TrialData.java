package info.alexandertyler.androidtrials.data;

import android.app.Activity;

/**
 * Created by Alex on 1/28/2017.
 */

public class TrialData {

    public String name;
    public Class<?> activity;

    public TrialData(String name, Class<?> activity) {
        this.name = name;
        this.activity = activity;
    }

}
