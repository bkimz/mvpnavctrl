package com.example.bk.informationorganizer.DataAccessObj;

import com.example.bk.informationorganizer.Models.CompanyModel;

import java.util.List;

/**
 * Created by bk on 1/12/2017.
 */

public interface CompanyDao {

   void createCompany(String name, String stock, String url, String compobjname);
   void deleteCompany();
   void editCompany();
    List <CompanyModel> getAllCompanies();





}
