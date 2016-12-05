package com.barranquero.dynamicfragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import static com.barranquero.dynamicfragment.Fragment_A.FRAGMENTA_TAG;

public class Fragment_Activity extends Activity implements Fragment_A.FragmentIterationListener {
    private Fragment_A fragment_a;
    private Fragment_B fragment_b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        fragment_a = (Fragment_A) getFragmentManager().findFragmentByTag(FRAGMENTA_TAG);
        if (fragment_a == null) {
            fragment_a = new Fragment_A();              //arguments not needed
            //fragment_a = Fragment_A.newInstance();    if arguments are needed
            getFragmentManager().beginTransaction().add(R.id.activity_fragment, fragment_a, FRAGMENTA_TAG).commit();
        }
    }

    @Override
    public void onFragmentIterationListener(String text, int size) {
        Bundle args = new Bundle();
        args.putString(Fragment_B.TEXT_KEY, text);
        args.putFloat(Fragment_B.SIZE_KEY, size);
        fragment_b = Fragment_B.newInstance(args);

        // FragmentA to FragmentB transaction starts
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_fragment, fragment_b);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
