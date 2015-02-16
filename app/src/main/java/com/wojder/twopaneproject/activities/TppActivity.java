package com.wojder.twopaneproject.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;

import com.wojder.twopaneproject.ContractBoxerListFragment;
import com.wojder.twopaneproject.R;
import com.wojder.twopaneproject.fragment.BoxerDetailsFragment;
import com.wojder.twopaneproject.fragment.BoxerListFragment;
import com.wojder.twopaneproject.model.Boxer;

/**
 * Created by wojder on 16.02.15.
 */
public class TppActivity extends Activity implements BoxerListFragment.Contract {
    private static final String TAG_DETAILS = "boxerDetails";
    private static final String TAG_BOXERS = "boxerList";
    private BoxerDetailsFragment boxerDetails = null;
    private BoxerListFragment boxerList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tpp_layout);

        boxerList = (BoxerListFragment) getFragmentManager().findFragmentByTag(TAG_BOXERS);
        boxerDetails = (BoxerDetailsFragment) getFragmentManager().findFragmentByTag(TAG_DETAILS);

        if (boxerList == null) {

            boxerList = new BoxerListFragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.main_container, boxerList, TAG_BOXERS).commit();
        }

        if (boxerDetails == null) {

            boxerDetails = new BoxerDetailsFragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.main_container, boxerDetails, TAG_DETAILS).commit();
        } else {
            if (boxerDetails.getId() == R.id.main_container) {
                if (findViewById(R.id.details_container) != null) {
                    getFragmentManager().popBackStackImmediate();
                }
            } else {
                getFragmentManager().beginTransaction()
                        .remove(boxerDetails).commit();
            }
            if (findViewById(R.id.details_container) != null) {
                getFragmentManager().beginTransaction()
                        .add(R.id.details_container, boxerDetails, TAG_DETAILS).commit();
            }
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {

    }

    @Override
    public void onBoxerSelected(Boxer box) {
        String url = getString(box.url);

        boxerDetails.loadUrl(url);

        if (boxerDetails.getId() != R.id.details_container) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.main_container, boxerDetails, TAG_DETAILS).commit();
        }
    }

    @Override
    public boolean isPersistentSelection() {
        return false;
    }
}
