package com.example.doanquanlytour.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanquanlytour.DataModels.KhachHang;


import java.util.ArrayList;

public class DBKhachHang {
    DBHelper dbHelper;
    public DBKhachHang(Context context) {
        dbHelper= new DBHelper(context);
    }

    public void Them(KhachHang kh)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MAKH",kh.getMaKH());
        values.put("TENKH",kh.getTenKH());
        values.put("DIACHI",kh.getDiaChi());

        db.insert("KHACHHANG",null,values);
        db.close();
    }
    public  void Sua(KhachHang kh)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MAKH",kh.getMaKH());
        values.put("TENKH",kh.getTenKH());
        values.put("DIACHI",kh.getDiaChi());

        db.update("KHACHHANG",values,"MAKH ='"+kh.getMaKH() +"'",null);
    }


    public  void Xoa(KhachHang kh)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql ="Delete from KHACHHANG where MAKH= '"+kh.getMaKH()+"'";
        db.execSQL(sql);
    }

    public ArrayList<KhachHang> LayDL()
    {
        ArrayList<KhachHang> data = new ArrayList<>();
        String sql="select * from KHACHHANG";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        do {
            KhachHang kh = new KhachHang();
            kh.setMaKH(cursor.getString( 0 ));
            kh.setTenKH(cursor.getString(1));
            kh.setDiaChi(cursor.getString(2));
            data.add(kh);
        }
        while (cursor.moveToNext());

        return  data;
    }

    public ArrayList<KhachHang> LayDL(String ma)
    {
        ArrayList<KhachHang> data = new ArrayList<>();
        String sql="select * from KHACHHANG where MAKH = '"+ma+"'";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        try {
            do {
                KhachHang kh = new KhachHang();
                kh.setMaKH(cursor.getString( 0 ));
                kh.setTenKH(cursor.getString(1));
                kh.setDiaChi(cursor.getString(2));
                data.add(kh);
            }
            while (cursor.moveToNext());
        }catch (Exception ex)
        {
        }
        return  data;
    }

}
