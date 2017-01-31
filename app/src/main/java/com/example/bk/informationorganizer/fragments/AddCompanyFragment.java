package com.example.bk.informationorganizer.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.bk.informationorganizer.DataAccessObj.CompanyDao;
import com.example.bk.informationorganizer.DataAccessObj.CompanyDaoImp;
import com.example.bk.informationorganizer.R;

/**
 * Created by bk on 1/11/2017.
 */

public class AddCompanyFragment extends Fragment implements View.OnClickListener{
    EditText etCompanyName, etStockSymbol, etImageURL;
    String compName, stockSymbol, imgURL;

    CompanyDao dao;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_company_fragment, container, false);
        etCompanyName = (EditText) view.findViewById(R.id.etcompanyName);
        etStockSymbol = (EditText) view.findViewById(R.id.etstockSymbol);
        etImageURL = (EditText) view.findViewById(R.id.etimageURL);

        Button cancelButton = (Button) view.findViewById(R.id.cancelButton);
        Button saveButton = (Button) view.findViewById(R.id.saveButton);
        cancelButton.setOnClickListener(this);
        saveButton.setOnClickListener(this);

        dao = CompanyDaoImp.getCompanyDaoInstance();


        return view;
    }

        @Override
        public void onClick(View v) {
            FragmentManager fragmentManager;
            fragmentManager = getActivity().getFragmentManager();
            dao = CompanyDaoImp.getCompanyDaoInstance();
            switch(v.getId()){
                case R.id.cancelButton:
                    fragmentManager.popBackStack();
                    //do something

                    break;

                case R.id.saveButton:
                  compName = etCompanyName.getText().toString();
                  stockSymbol = etStockSymbol.getText().toString();
                  imgURL = etImageURL.getText().toString();

                    if(TextUtils.isEmpty(compName)){
                        etCompanyName.setError("Please enter a company name.");
                    }
                    if(TextUtils.isEmpty(stockSymbol)){
                        etStockSymbol.setError("Please enter the stock ticker.");
                    }
                    if(TextUtils.isEmpty(imgURL)){
                        etImageURL.setError("Please enter image URL");
                    }else {

                        dao.createCompany(compName, stockSymbol, imgURL, compName);

                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.replace(R.id.fragment_container, new CompanyListFragment()).commit();
                    }
                    break;
            }

        }


    }


