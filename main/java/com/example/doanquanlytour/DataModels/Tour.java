package com.example.doanquanlytour.DataModels;

public class Tour {


    String MaTour;
    String LoTrinh;
    String HanhTrinh;
    String GiaTour;

    public Tour() {
    }

    public Tour(String maTour, String loTrinh, String hanhTrinh, String giaTour) {
        MaTour = maTour;
        LoTrinh = loTrinh;
        HanhTrinh = hanhTrinh;
        GiaTour = giaTour;
    }
    public String getMaTour() {
        return MaTour;
    }

    public void setMaTour(String maTour) {
        MaTour = maTour;
    }

    public String getLoTrinh() {
        return LoTrinh;
    }

    public void setLoTrinh(String loTrinh) {
        LoTrinh = loTrinh;
    }

    public String getHanhTrinh() {
        return HanhTrinh;
    }

    public void setHanhTrinh(String hanhTrinh) {
        HanhTrinh = hanhTrinh;
    }

    public String getGiaTour() {
        return GiaTour;
    }

    public void setGiaTour(String giaTour) {
        GiaTour = giaTour;
    }



}
