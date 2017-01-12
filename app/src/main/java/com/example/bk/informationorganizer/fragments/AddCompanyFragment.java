package com.example.bk.informationorganizer.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bk.informationorganizer.R;

/**
 * Created by bk on 1/11/2017.
 */

public class AddCompanyFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.addcompanyfragment, container, false);

        return view;
    }
}
