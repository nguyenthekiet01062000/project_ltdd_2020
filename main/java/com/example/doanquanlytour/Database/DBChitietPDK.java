package com.example.doanquanlytour.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanquanlytour.DataModels.ChitietPDK;

import java.util.ArrayList;

public class DBChitietPDK {
    DBHelper dbHelper;
    public DBChitietPDK(Context context) {
        dbHelper= new DBHelper(context);
    }

    public void Them(ChitietPDK ctPDK)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("SOPHIEU",ctPDK.getSoPhieu());
        values.put("MATOUR",ctPDK.getMaTour());
        values.put("SONGUOI",ctPDK.getSoNguoi());

        db.insert("CHITIETPDK",null,values);
        db.close();
    }
    public  void Sua(ChitietPDK ctPDK)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("SOPHIEU",ctPDK.getSoPhieu());
        values.put("MATOUR",ctPDK.getMaTour());
        values.put("SONGUOI",ctPDK.getSoNguoi());
        db.update("CHITIETPDK",values,"SOPHIEU ='"+ctPDK.getSoPhieu() +"'",null);
    }


    public  void Xoa(ChitietPDK ctPDK)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql ="Delete from CHITIETPDK where SOPHIEU= '"+ctPDK.getSoPhieu()+"'";
        db.execSQL(sql);
    }

    public ArrayList<ChitietPDK> LayDL()
    {
        ArrayList<ChitietPDK> data = new ArrayList<>();
        String sql="select * from CHITIETPDK";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        do {
            ChitietPDK ctPdk = new ChitietPDK();
            ctPdk.setSoPhieu(cursor.getString( 0 ));
            ctPdk.setMaTour(cursor.getString(1));
            ctPdk.setSoNguoi(cursor.getString(2));
            data.add(ctPdk);
        }
        while (cursor.moveToNext());

        return  data;
    }

    public ArrayList<ChitietPDK> LayDL(String ma)
    {
        ArrayList<ChitietPDK> data = new ArrayList<>();
        String sql="select * from CHITIETPDK where SOPHIEU = '"+ma+"'";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        try {
            do {
                ChitietPDK ctPdk = new ChitietPDK();
                ctPdk.setSoPhieu(cursor.getString( 0 ));
                ctPdk.setMaTour(cursor.getString(1));
                ctPdk.setSoNguoi(cursor.getString(2));
                data.add(ctPdk);
            }
            while (cursor.moveToNext());
        }catch (Exception ex)
        {
        }
        return  data;
    }
}
