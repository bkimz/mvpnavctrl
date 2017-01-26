package com.example.bk.informationorganizer.DataAccessObj;

import com.example.bk.informationorganizer.Models.CompanyModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bk on 1/12/2017.
 */

public class CompanyDaoImp implements CompanyDao {

    public static ArrayList<CompanyModel> companyList = new ArrayList<CompanyModel>();


    public static CompanyDaoImp onlyCompanyDaoInstance = new CompanyDaoImp();

    private CompanyDaoImp(){



    }

    public static CompanyDaoImp getCompanyDaoInstance(){

        return onlyCompanyDaoInstance;

    }

    public void createCompany(String name, String stock, String url, String companyobjname){
        // Note need to make it so that each company created has a unique name
        CompanyModel companyobjectname = new CompanyModel(name, stock, url);
        companyList.add(companyobjectname);

    }



    @Override
    public void deleteCompany() {

    }

    @Override
    public void editCompany() {

    }

    @Override
    public List<CompanyModel> getAllCompanies()
    {
        return companyList;
    }
}
