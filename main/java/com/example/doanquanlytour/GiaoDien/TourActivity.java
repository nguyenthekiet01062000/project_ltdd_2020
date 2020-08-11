package com.example.doanquanlytour.GiaoDien;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doanquanlytour.Apdapter.AdapterTour;
import com.example.doanquanlytour.DataModels.Tour;
import com.example.doanquanlytour.Database.DBTour;
import com.example.doanquanlytour.R;


import java.util.ArrayList;

public class TourActivity extends AppCompatActivity {
EditText txtMaTour,txtLoTrinh,txtHanhTrinh,txtGiaTour;
Button btnThem, btnXoa,btnSua,btnClear;
ListView lvDanhSach;

AdapterTour adapterTour;
ArrayList<Tour> data_Tour = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

     setControl();
      setEvent();
    }

    private void setEvent() {

        hienthidulieu();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBTour dbTour = new DBTour(TourActivity.this);
                Tour tour = new Tour();
                tour.setMaTour(txtMaTour.getText().toString());
                tour.setLoTrinh(txtLoTrinh.getText().toString());
                tour.setHanhTrinh(txtHanhTrinh.getText().toString());
                tour.setGiaTour(txtGiaTour.getText().toString());
                dbTour.Them(tour);
                hienthidulieu();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBTour dbTour = new DBTour(TourActivity.this);
                Tour tour = new Tour();
                tour.setMaTour(txtMaTour.getText().toString());
                tour.setLoTrinh(txtLoTrinh.getText().toString());
                tour.setHanhTrinh(txtHanhTrinh.getText().toString());
                tour.setGiaTour(txtGiaTour.getText().toString());
                dbTour.Xoa(tour);
                hienthidulieu();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBTour dbTour = new DBTour(TourActivity.this);
                Tour tour = new Tour();
                tour.setMaTour(txtMaTour.getText().toString());
                tour.setLoTrinh(txtLoTrinh.getText().toString());
                tour.setHanhTrinh(txtHanhTrinh.getText().toString());
                tour.setGiaTour(txtGiaTour.getText().toString());
                dbTour.Sua(tour);
                hienthidulieu();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMaTour.setText("");
                txtLoTrinh.setText("");
                txtHanhTrinh.setText("");
                txtGiaTour.setText("");
            }
        });

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tour tour = data_Tour.get(position);
                txtMaTour.setText(tour.getMaTour());
                txtLoTrinh.setText(tour.getLoTrinh());
                txtHanhTrinh.setText(tour.getHanhTrinh());
                txtGiaTour.setText(tour.getGiaTour());
            }
        });
    }

    private void hienthidulieu() {
        DBTour dbTour = new DBTour(this);
        data_Tour = dbTour.LayDL();
        adapterTour = new AdapterTour(this,R.layout.item_list_tour,data_Tour);
        lvDanhSach.setAdapter(adapterTour);
    }

    private void setControl() {
        txtMaTour = findViewById(R.id.txtMaTour);
        txtLoTrinh = findViewById(R.id.txtLoTrinh);
        txtHanhTrinh = findViewById(R.id.txtHanhTrinh);
        txtGiaTour = findViewById(R.id.txtGiaTour);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        btnClear = findViewById(R.id.btnClear);
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }
}
