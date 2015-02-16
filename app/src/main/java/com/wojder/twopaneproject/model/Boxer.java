package com.wojder.twopaneproject.model;

import com.wojder.twopaneproject.R;

import java.util.ArrayList;

/**
 * Created by wojder on 16.02.15.
 */
public class Boxer {
    public int boxerName;
    public int boxerDescription;
    public int url;

    public Boxer(int boxerName, int boxerDescription, int url) {
        this.boxerName = boxerName;
        this.boxerDescription = boxerDescription;
        this.url = url;
    }

    public static ArrayList<Boxer> BoxerListExkalibur = new ArrayList<Boxer>();
    public static ArrayList<Boxer> BoxerListEwenement = new ArrayList<Boxer>();

    static {
        BoxerListExkalibur.add(new Boxer(R.string.dias, R.string.dias_desc, 1));
        BoxerListExkalibur.add(new Boxer(R.string.odwet, R.string.odwet_desc, 2));
        BoxerListExkalibur.add(new Boxer(R.string.next, R.string.next_desc, 3));
        BoxerListEwenement.add(new Boxer(R.string.eliza, R.string.eliza_desc, 4));
        BoxerListEwenement.add(new Boxer(R.string.amelia, R.string.amelinium_desc, 5));
    }
}
