package com.barranquero.dynamicfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment_B extends Fragment {
    private TextView txtFragmentB;
    public static final String TEXT_KEY = "text";
    public static final String SIZE_KEY = "fontsize";
    public static final String FRAGMENTB_TAG = "fragmentB";

    public Fragment_B() {
        // Required empty public constructor
    }

    public static Fragment_B newInstance(Bundle args) {
        Fragment_B fragment = new Fragment_B();
        if (args != null)
            fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_b, container, false);
        if (rootView != null) {
            txtFragmentB = (TextView)rootView.findViewById(R.id.txvText);
            Bundle bundle = getArguments();
            if (bundle != null) {
                txtFragmentB.setText(bundle.getString(TEXT_KEY));
                txtFragmentB.setTextSize(bundle.getFloat(SIZE_KEY));
            }
        }
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_KEY, txtFragmentB.getText().toString());
        outState.putFloat(SIZE_KEY, txtFragmentB.getTextSize()/getResources().getDisplayMetrics().density);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            String text = savedInstanceState.getString(TEXT_KEY);
            int fontSize = (int)savedInstanceState.getFloat(SIZE_KEY);
            changeTextProperties(text, fontSize);
        }
    }

    /**
     * Method which modifies the text and font size
     * @param text        The text to be displayed
     * @param fontSize    The font size
     */
    public void changeTextProperties(String text, int fontSize) {
        txtFragmentB.setText(text);
        txtFragmentB.setTextSize(fontSize);
    }
}
