package com.barranquero.dynamicfragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class Fragment_A extends Fragment {
    private SeekBar skbFragmentA;
    private Button btnChange;
    private EditText edtText;
    private FragmentIterationListener mCallBack;
    public static final String FRAGMENTA_TAG = "fragmentA";

    public interface FragmentIterationListener {
        void onFragmentIterationListener(String text, int size);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {

            mCallBack = (FragmentIterationListener)activity;

        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement FragmentIterationListener interface");
        }
    }

    public Fragment_A() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Retain this fragment across configuration changes
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        if(view != null){

            edtText = (EditText)view.findViewById(R.id.edtText);
            skbFragmentA = (SeekBar)view.findViewById(R.id.skbScroll);
            btnChange = (Button)view.findViewById(R.id.btnChange);

            btnChange.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCallBack.onFragmentIterationListener(edtText.getText().toString(), skbFragmentA.getProgress());
                }
            });
        }
        return view;
    }

}
