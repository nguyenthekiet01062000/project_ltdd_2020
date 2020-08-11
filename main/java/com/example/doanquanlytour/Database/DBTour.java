package com.example.doanquanlytour.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanquanlytour.DataModels.Tour;

import java.util.ArrayList;

public class DBTour  {
    DBHelper dbHelper;
    public DBTour(Context context) {
        dbHelper= new DBHelper(context);
    }

    public void Them(Tour tour)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MATOUR",tour.getMaTour());
        values.put("LOTRINH",tour.getLoTrinh());
        values.put("HANHTRINH",tour.getHanhTrinh());
        values.put("GIA",tour.getGiaTour());
        db.insert("TOUR",null,values);
        db.close();
    }
    public  void Sua(Tour tour)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MATOUR",tour.getMaTour());
        values.put("LOTRINH",tour.getLoTrinh());
        values.put("HANHTRINH",tour.getHanhTrinh());
        values.put("GIA",tour.getGiaTour());
        db.update("TOUR",values,"MATOUR ='"+tour.getMaTour() +"'",null);
    }


    public  void Xoa(Tour tour)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql ="Delete from TOUR where MATOUR= '"+tour.getMaTour()+"'";
        db.execSQL(sql);
    }

    public ArrayList<Tour> LayDL()
    {
        ArrayList<Tour> data = new ArrayList<>();
        String sql="select * from TOUR";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        do {
            Tour tour = new Tour();
           tour.setMaTour(cursor.getString(0));
            tour.setLoTrinh(cursor.getString(1));
            tour.setHanhTrinh(cursor.getString(2));
            tour.setGiaTour(cursor.getString(3));
            data.add(tour);
        }
        while (cursor.moveToNext());

        return  data;
    }

    public ArrayList<Tour> LayDL(String ma)
    {
        ArrayList<Tour> data = new ArrayList<>();
        String sql="select * from TOUR where MATOUR = '"+ma+"'";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        try {
            do {
                Tour tour = new Tour();
                tour.setMaTour(cursor.getString( 0 ));
                tour.setLoTrinh(cursor.getString(1));
                tour.setHanhTrinh(cursor.getString(2));
                tour.setGiaTour(cursor.getString(3));
                data.add(tour);
            }
            while (cursor.moveToNext());
        }catch (Exception ex)
        {
        }
        return  data;
    }



}
