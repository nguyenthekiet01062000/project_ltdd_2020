package com.example.doanquanlytour.DataModels;

public class ChitietPDK {
    String SoPhieu,MaTour,SoNguoi;

    public ChitietPDK() {
    }

    public ChitietPDK(String soPhieu, String maTour, String soNguoi) {
        SoPhieu = soPhieu;
        MaTour = maTour;
        SoNguoi = soNguoi;
    }

    public String getSoPhieu() {
        return SoPhieu;
    }

    public void setSoPhieu(String soPhieu) {
        SoPhieu = soPhieu;
    }

    public String getMaTour() {
        return MaTour;
    }

    public void setMaTour(String maTour) {
        MaTour = maTour;
    }

    public String getSoNguoi() {
        return SoNguoi;
    }

    public void setSoNguoi(String soNguoi) {
        SoNguoi = soNguoi;
    }
}
