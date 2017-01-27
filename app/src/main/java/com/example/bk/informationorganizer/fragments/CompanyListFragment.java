package com.example.bk.informationorganizer.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.bk.informationorganizer.CompanyAdapter;
import com.example.bk.informationorganizer.DataAccessObj.CompanyDao;
import com.example.bk.informationorganizer.DataAccessObj.CompanyDaoImp;
import com.example.bk.informationorganizer.ItemClickSupport;
import com.example.bk.informationorganizer.R;

import static com.example.bk.informationorganizer.R.id.recyclerView;

/**
 * Created by bk on 1/11/2017.
 */

public class CompanyListFragment extends Fragment implements View.OnClickListener {
    CompanyDao dao;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView mRecyclerView;
    CompanyAdapter mAdapter;
    ItemClickSupport itemClickSupport;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        dao = CompanyDaoImp.getCompanyDaoInstance();
        View view = inflater.inflate(R.layout.watchlist_fragment, container, false);

        ImageButton addButton = (ImageButton) view.findViewById(R.id.plusButton);
        Button editButton = (Button) view.findViewById(R.id.editButton);

        addButton.setOnClickListener(this);
        editButton.setOnClickListener(this);

        mRecyclerView = (RecyclerView) view.findViewById(recyclerView);
        itemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener(){
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v){
                Log.d("position", ""+ position);
            }

        });

        mLayoutManager  = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);


        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CompanyAdapter(dao.getAllCompanies(),getActivity().getBaseContext());
        mRecyclerView.setAdapter(mAdapter);



        return view;
    }


    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()){
            case R.id.plusButton:
                fragment = new AddCompanyFragment();
                replaceFragment(fragment);
                //do something
                break;

            case R.id.editButton:
                //do something
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
