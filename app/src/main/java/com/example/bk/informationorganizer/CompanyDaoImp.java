package com.example.bk.informationorganizer;

import java.util.List;

/**
 * Created by bk on 1/12/2017.
 */

public class CompanyDaoImp implements CompanyDao {
    public static List<CompanyModel> testList;


    public static CompanyDaoImp onlyCompanyDaoInstance = new CompanyDaoImp();

    private CompanyDaoImp(){



    }

    public static CompanyDaoImp getCompanyDaoInstance(){

        return onlyCompanyDaoInstance;

    }

    public void createCompany(String name, String stock, String url){
        CompanyModel test1 = new CompanyModel(name, stock, url);
        testList.add(test1);


    }



    @Override
    public void addCompany(CompanyModel companyModel) {



    }

    @Override
    public void deleteCompany() {

    }

    @Override
    public void editCompany() {

    }

    @Override
    public List<CompanyModel> getAllCompanies() {
        return null;
    }
}
