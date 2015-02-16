package com.wojder.twopaneproject;

import android.view.View;
import android.widget.TextView;

import com.wojder.twopaneproject.model.Boxer;

/**
 * Created by wojder on 16.02.15.
 */
public class BoxerViewHolder {
    TextView boxerDesc = null;
    TextView boxerName = null;

    public BoxerViewHolder(View boxer_row) {
        boxerName = (TextView) boxer_row.findViewById(R.id.boxer_name);
        boxerDesc = (TextView) boxer_row.findViewById(R.id.boxer_desc);
    }

    public TextView getBoxerDesc() {
        return boxerDesc;
    }

    public TextView getBoxerName() {
        return boxerName;
    }

    public void populateFrom(Boxer boxer) {
        getBoxerName().setText(boxer.boxerName);
        getBoxerDesc().setText(boxer.boxerDescription);
    }
}
