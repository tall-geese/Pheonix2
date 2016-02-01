package com.example.mark.pheonix2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mark on 1/27/2016.
 */
public class PagerFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //this may be incorrect, might need to cast as a viewgroup here then return that
        return inflater.inflate(R.layout.fragment_content, container, false);

    }
}
