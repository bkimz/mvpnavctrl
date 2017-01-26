package com.example.bk.informationorganizer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bk.informationorganizer.DataAccessObj.CompanyDao;
import com.example.bk.informationorganizer.DataAccessObj.CompanyDaoImp;
import com.example.bk.informationorganizer.Models.CompanyModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by bk on 1/12/2017.
 */

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.ViewHolder> {

    List<CompanyModel> companyModels;
    private Context context;
    CompanyDao dao;

    public CompanyAdapter(List<CompanyModel> companyModels, Context context) {
        this.companyModels = companyModels;
        this.context = context;
        dao = CompanyDaoImp.getCompanyDaoInstance();
    }

    @Override
   // This method will be called whenever our ViewHolder is created. When an instance of below ViewHolder class is created.
    public CompanyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.company_list_row, parent, false);


        return new ViewHolder(v);
    }

    //This method will be called after onCreateViewHolder and will bind the data to the ViewHolder
    // and aide in showing the data to the recyclerview.
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // As I am using DAO, I switched companyModel to companyModel1. Remove commented code below later.
//        CompanyModel companyModel = companyModels.get(position);

        CompanyModel companyModel1 = dao.getAllCompanies().get(position);


        holder.companyTextView.setText(companyModel1.getCompName() + " (" +companyModel1.getCompTicker()+")");
        holder.priceTextView.setText(companyModel1.getCompPrice());

        Picasso.with(context)
                .load(companyModel1.getCompImageURL())
                .into(holder.companyImageView);
    }


    @Override
    public int getItemCount() {
        //replaced companyModels.size with dao.getallcompanies.size();
        return dao.getAllCompanies().size();
                //companyModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView companyTextView;
        public TextView priceTextView;
        public ImageView companyImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            companyTextView = (TextView) itemView.findViewById(R.id.tv_companyname);
            priceTextView = (TextView) itemView.findViewById(R.id.tv_companyprice);
            companyImageView = (ImageView) itemView.findViewById(R.id.iv_company);
        }
    }


}
