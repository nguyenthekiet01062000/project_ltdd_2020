package com.example.doanquanlytour.DataModels;

public class KhachHang {
    public KhachHang() {
    }

    String MaKH;
    String TenKH;
    String DiaChi;

    public KhachHang(String maKH, String tenKH, String diaChi) {
        MaKH = maKH;
        TenKH = tenKH;
        DiaChi = diaChi;
    }


    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }
}
