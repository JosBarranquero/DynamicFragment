package com.barranquero.dynamicfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class Fragment_C extends Fragment {
    private WebView wvAboutUs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_c, container, false);
        wvAboutUs = (WebView)rootView.findViewById(R.id.web);
        wvAboutUs.loadData(getResources().getString(R.string.aboutus), "text/html", Xml.Encoding.UTF_8.toString());

        return rootView;
    }
}
