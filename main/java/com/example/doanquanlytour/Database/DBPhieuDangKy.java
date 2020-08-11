package com.example.doanquanlytour.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanquanlytour.DataModels.PhieuDangKy;

import java.util.ArrayList;

public class DBPhieuDangKy {
    DBHelper dbHelper;
    public DBPhieuDangKy(Context context) {
        dbHelper= new DBHelper(context);
    }

    public void Them(PhieuDangKy pdk)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("SOPHIEU",pdk.getSoPhieu());
        values.put("NGAYDK",pdk.getNgayDK());
        values.put("MAKH",pdk.getMaKH());

        db.insert("PHIEUDANGKY",null,values);
        db.close();
    }
    public  void Sua(PhieuDangKy pdk)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("SOPHIEU",pdk.getSoPhieu());
        values.put("NGAYDK",pdk.getNgayDK());
        values.put("MAKH",pdk.getMaKH());

        db.update("PHIEUDANGKY",values,"SOPHIEU ='"+pdk.getSoPhieu() +"'",null);
    }


    public  void Xoa(PhieuDangKy pdk)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql ="Delete from PHIEUDANGKY where SOPHIEU= '"+pdk.getSoPhieu()+"'";
        db.execSQL(sql);
    }

    public ArrayList<PhieuDangKy> LayDL()
    {
        ArrayList<PhieuDangKy> data = new ArrayList<>();
        String sql="select * from PHIEUDANGKY";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        do {
            PhieuDangKy pdk = new PhieuDangKy();
            pdk.setSoPhieu(cursor.getString( 0 ));
            pdk.setNgayDK(cursor.getString(1));
            pdk.setMaKH(cursor.getString(2));
            data.add(pdk);
        }
        while (cursor.moveToNext());

        return  data;
    }

    public ArrayList<PhieuDangKy> LayDL(String ma)
    {
        ArrayList<PhieuDangKy> data = new ArrayList<>();
        String sql="select * from PHIEUDANGKY where SOPHIEU = '"+ma+"'";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        try {
            do {
                PhieuDangKy pdk = new PhieuDangKy();
                pdk.setSoPhieu(cursor.getString( 0 ));
                pdk.setNgayDK(cursor.getString(1));
                pdk.setMaKH(cursor.getString(2));
                data.add(pdk);
            }
            while (cursor.moveToNext());
        }catch (Exception ex)
        {
        }
        return  data;
    }
}
