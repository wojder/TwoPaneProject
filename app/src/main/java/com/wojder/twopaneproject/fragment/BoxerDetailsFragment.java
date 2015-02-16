package com.wojder.twopaneproject.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewFragment;

import com.wojder.twopaneproject.R;

public class BoxerDetailsFragment extends WebViewFragment {

    private static final String STATE_URL="url";
    private String url=null;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (url == null && savedInstanceState != null) {
            url=savedInstanceState.getString(STATE_URL);
        }

        if (url != null) {
            loadUrl(url);
            url=null;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (url == null) {
            outState.putString(STATE_URL, getWebView().getUrl());
        }
        else {
            outState.putString(STATE_URL, url);
        }
    }

    public void loadUrl(String url) {
        if (getView() == null) {
            this.url=url;
        }
        else {
            getWebView().loadUrl(url);
        }
    }}

