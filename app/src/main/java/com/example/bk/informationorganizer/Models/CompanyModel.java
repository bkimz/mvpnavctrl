package com.example.bk.informationorganizer.Models;

import com.example.bk.informationorganizer.ProductModel;

import java.util.List;

/**
 * Created by bk on 1/12/2017.
 */

public class CompanyModel {
    private String compName;
    private String compTicker;
    private String compPrice;
    private String compImageURL;
    private List<ProductModel> productModelList;

    public CompanyModel(){

    }

    public CompanyModel(String compName, String compTicker, String compPrice, String compImageURL, List<ProductModel> productModelList) {
        this.compName = compName;
        this.compTicker = compTicker;
        this.compPrice = compPrice;
        this.compImageURL = compImageURL;
        this.productModelList = productModelList;
    }

    public CompanyModel(String compName, String compTicker, String compImageURL){
        this.compName = compName;
        this.compTicker = compTicker;
        this.compImageURL = compImageURL;
    }

    public CompanyModel(String compName, String compTicker, String compPrice, String compImageURL) {
        this.compName = compName;
        this.compTicker = compTicker;
        this.compPrice = compPrice;
        this.compImageURL = compImageURL;
    }


    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompTicker() {
        return compTicker;
    }

    public void setCompTicker(String compTicker) {
        this.compTicker = compTicker;
    }

    public String getCompPrice() {
        return compPrice;
    }

    public void setCompPrice(String compPrice) {
        this.compPrice = compPrice;
    }

    public String getCompImageURL() {
        return compImageURL;
    }

    public void setCompImageURL(String compImageURL) {
        this.compImageURL = compImageURL;
    }

    public List<ProductModel> getProductModelList() {
        return productModelList;
    }

    public void setProductModelList(List<ProductModel> productModelList) {
        this.productModelList = productModelList;
    }

}
