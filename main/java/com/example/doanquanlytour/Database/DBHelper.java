package com.example.doanquanlytour.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper( Context context) {
        super(context, "QLTour", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql="create table KHACHHANG(MAKH text, TENKH Text ,DIACHI Text)";
        db.execSQL(sql);
        sql="insert into KHACHHANG values('KH01','Nguyen The Kiet','Dong Nai')";
        db.execSQL(sql);
        sql="insert into KHACHHANG values('KH02','Nguyen The a','HCM')";
        db.execSQL(sql);

        sql="create table PHIEUDANGKY(SOPHIEU text, NGAYDK Text ,MAKH Text)";
        db.execSQL(sql);
        sql="insert into PHIEUDANGKY values('01','01/06/2020','KH01')";
        db.execSQL(sql);
        sql="insert into PHIEUDANGKY values('02','01/07/2020','KH02')";
        db.execSQL(sql);


        sql="create table CHITIETPDK(SOPHIEU text, MATOUR Text ,SONGUOI Text)";
        db.execSQL(sql);
        sql="insert into CHITIETPDK values('01','MT01','10')";
        db.execSQL(sql);
        sql="insert into CHITIETPDK values('02','MT02','11')";
        db.execSQL(sql);

         sql="create table TOUR(MATOUR text, LOTRINH Text ,HANHTRINH Text,GIA TEXT)";
        db.execSQL(sql);
        sql="insert into TOUR values('MT01','TPHCM-Da Nang','3 ngay 2 dem','500000')";
        db.execSQL(sql);
        sql="insert into TOUR values('MT02','TPHCM-Phan Thiet','2 ngay 2 dem','600000')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
