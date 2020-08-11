package com.example.doanquanlytour.DataModels;

public class PhieuDangKy {
    String SoPhieu,NgayDK,MaKH;

    public PhieuDangKy() {
    }

    public PhieuDangKy(String soPhieu, String ngayDK, String maKH) {
        SoPhieu = soPhieu;
        NgayDK = ngayDK;
        MaKH = maKH;
    }

    public String getSoPhieu() {
        return SoPhieu;
    }

    public void setSoPhieu(String soPhieu) {
        SoPhieu = soPhieu;
    }

    public String getNgayDK() {
        return NgayDK;
    }

    public void setNgayDK(String ngayDK) {
        NgayDK = ngayDK;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }
}
