package info.alexandertyler.androidtrials.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.alexandertyler.androidtrials.R;

/**
 * Created by Alex on 1/28/2017.
 */

public class HashMapActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.key)
    EditText key;
    @BindView(R.id.value)
    EditText value;

    private TrialHashMap trialHashMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hash_map);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(android.R.drawable.btn_star);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // initialize our trial hash map
        trialHashMap = new TrialHashMap();
    }

    public void onPut(View view) {
        String mKey = key.getText().toString();
        String mValue = value.getText().toString();
        trialHashMap.put(mKey, mValue);
    }

    public void onGet(View view) {
        String mKey = key.getText().toString();
        String mValue = trialHashMap.get(mKey);
        if (mValue != null) {
            value.setText(mValue);
        } else {
            value.setText("");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }
}

class TrialHashMap {
    private static int MAP_SIZE = 12;

    private HashMapElement[] map = new HashMapElement[MAP_SIZE];

    public TrialHashMap() {
    }

    public void put(String key, String value) {
        HashMapElement newElement = new HashMapElement(key, value);
        int hashCode = key.hashCode() % MAP_SIZE;
        hashCode = hashCode < 0 ? hashCode + MAP_SIZE : hashCode;
        if (map[hashCode] == null) {
            map[hashCode] = newElement;
        } else {
            // grab the first element and check if the key matches
            HashMapElement currElement = map[hashCode];
            while (!currElement.key.equals(newElement.key)) {
                // if it doesn't match and there is another element in the array, switch to it
                if (currElement.next != null) {
                    currElement = currElement.next;
                } else {
                    // if there is no neext, new becomes next
                    currElement.next = newElement;
                    return;
                }
            }
            //we have found a matching key, override the value
            currElement.value = newElement.value;
        }
    }

    public String get(String key) {
        int hashCode = key.hashCode() % MAP_SIZE;
        hashCode = hashCode < 0 ? hashCode + MAP_SIZE : hashCode;
        if (map[hashCode] == null) return null;
        if (map[hashCode].key.equals(key)) {
            return map[hashCode].value;
        } else {
            HashMapElement currElement = map[hashCode];
            while (!currElement.key.equals(key)) {
                if (currElement.next != null) {
                    currElement = currElement.next;
                } else {
                    return null;
                }

            }
            return currElement.value;
        }
    }
}

class HashMapElement {

    public String key;
    public String value;
    public HashMapElement next;

    public HashMapElement(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
