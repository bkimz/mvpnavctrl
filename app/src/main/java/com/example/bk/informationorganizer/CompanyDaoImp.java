package com.example.bk.informationorganizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bk on 1/12/2017.
 */

public class CompanyDaoImp implements CompanyDao {
    public static ArrayList<CompanyModel> companyList;


    public static CompanyDaoImp onlyCompanyDaoInstance = new CompanyDaoImp();

    private CompanyDaoImp(){



    }

    public static CompanyDaoImp getCompanyDaoInstance(){

        return onlyCompanyDaoInstance;

    }

    public void createCompany(String name, String stock, String url){
        CompanyModel company = new CompanyModel(name, stock, url);
        companyList = new ArrayList<CompanyModel>();
        companyList.add(company);


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
