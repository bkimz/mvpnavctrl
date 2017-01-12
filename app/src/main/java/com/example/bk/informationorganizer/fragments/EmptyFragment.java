package com.example.bk.informationorganizer.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bk.informationorganizer.R;

/**
 * Created by bk on 1/11/2017.
 */

public class EmptyFragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nocompanyfragment, container, false);

        TextView blankslate1 = (TextView) view.findViewById(R.id.blankstate1);
        TextView blankslate2 = (TextView) view.findViewById(R.id.blankstate2);

        Button addCompanyButton = (Button) view.findViewById(R.id.addcompanybutton);
        ImageButton plusButton = (ImageButton) view.findViewById(R.id.plusButton);

        addCompanyButton.setOnClickListener(this);
        plusButton.setOnClickListener(this);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(),"fonts/System San Francisco Display Regular.ttf");
        blankslate1.setTypeface(font);
        blankslate2.setTypeface(font);
        addCompanyButton.setTypeface(font);


        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch(v.getId()){
            case R.id.addcompanybutton:
                fragment = new AddCompanyFragment();
                replaceFragment(fragment);
                break;
            case R.id.plusButton:
                fragment = new AddCompanyFragment();
                replaceFragment(fragment);
                break;

        }
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
