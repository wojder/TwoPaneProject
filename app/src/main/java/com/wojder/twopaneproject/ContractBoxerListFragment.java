package com.wojder.twopaneproject;

import android.app.Activity;
import android.app.ListFragment;

/**
 * Created by wojder on 16.02.15.
 */
public class ContractBoxerListFragment<T> extends ListFragment {
    private T contract;

    @Override
    public void onDetach() {
        super.onDetach();

        contract = null;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            contract = (T)activity;
        } catch (ClassCastException e) {
            throw new IllegalStateException(activity.getClass().getSimpleName()
            + " dones not implemennt contract interface for "
            + getClass().getSimpleName(), e);
        }
    }
    public final T getContract(){
        return(contract);
    }
}
