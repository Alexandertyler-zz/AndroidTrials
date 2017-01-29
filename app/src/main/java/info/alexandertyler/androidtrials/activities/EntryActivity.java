package info.alexandertyler.androidtrials.activities;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Alex on 1/28/2017.
 */

public class EntryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // any initialization of the app should go in this file
        // for now just launch into main activity

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
