package com.wojder.twopaneproject.fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wojder.twopaneproject.BoxerViewHolder;
import com.wojder.twopaneproject.ContractBoxerListFragment;
import com.wojder.twopaneproject.R;
import com.wojder.twopaneproject.model.Boxer;

import java.util.List;

public class BoxerListFragment extends ContractBoxerListFragment<BoxerListFragment.Contract> {
    private static final String STATE_CHECKED = "CHECKED";

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new BoxerAdapter());

        if (savedInstanceState != null) {
            int position = savedInstanceState.getInt(STATE_CHECKED, -1);

            if (position > -1) {
                getListView().setItemChecked(position, true);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (getView() != null){
            outState.putInt(STATE_CHECKED,
                    getListView().getCheckedItemPosition());
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (getContract().isPersistentSelection()) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            l.setItemChecked(position, true);
        } else {
            getListView().setChoiceMode(ListView.CHOICE_MODE_NONE);
        }
        getContract().onBoxerSelected(Boxer.BoxerListExkalibur.get(position));
    }

    public class BoxerAdapter extends ArrayAdapter<Boxer> {
        public BoxerAdapter() {
            super(getActivity(), R.layout.boxer_row, R.id.boxer_name);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            BoxerViewHolder wrapper = null;
            if (convertView == null) {
                convertView =
                        LayoutInflater.from(getActivity()).inflate(R.layout.boxer_row, parent, false);

                wrapper = new BoxerViewHolder(convertView);
                convertView.setTag(wrapper);
            } else {
                wrapper= (BoxerViewHolder) convertView.getTag();
            }
                wrapper.populateFrom(getItem(position));
                return (convertView);
        }
    }
    public interface Contract{
        void onBoxerSelected(Boxer box);

        boolean isPersistentSelection();
    }
}
