package com.example.medicinebd;

public class MedClass {

    int brandid,geneticid,companyid;
    String brandname,form,strength,pakesize,price,genname,comname ;

    public MedClass(int brandid, int geneticid, int companyid, String brandname, String form, String strength, String price, String pakesize, String genname, String comname)
    {

        this.brandid=brandid;
        this.geneticid=geneticid;
        this.companyid=companyid;
        this.brandname=brandname;
        this.form=form;
        this.strength=strength;
        this.price=price;
        this.pakesize=pakesize;
        this.genname=genname;
        this.comname=comname;


    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGenname() {
        return genname;
    }

    public void setGenname(String genname) {
        this.genname = genname;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public int getGeneticid() {
        return geneticid;
    }

    public void setGeneticid(int geneticid) {
        this.geneticid = geneticid;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getPakesize() {
        return pakesize;
    }

    public void setPakesize(String pakesize) {
        this.pakesize = pakesize;
    }
}
