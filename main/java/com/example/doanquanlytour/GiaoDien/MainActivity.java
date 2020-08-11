package com.example.doanquanlytour.GiaoDien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.doanquanlytour.R;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    AnimationDrawable animationDrawable = null;
    Button btKhachHang,btTour,btnPhieuDangKy,btnchitietPDK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btKhachHang = findViewById(R.id.btnKhachHang);
        btTour = findViewById(R.id.btnTour);
        btnPhieuDangKy = findViewById(R.id.btnPhieuDangKy);
        btnchitietPDK = findViewById(R.id.btnchitietPDK);
        setControl();

        setEvent();
        img.setBackgroundResource(R.drawable.chuyendongcar);
        animationDrawable = (AnimationDrawable) img.getBackground();
        animationDrawable.start();
    }

    private void setEvent() {
        btTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TourActivity.class));
            }
        });
        btKhachHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,KhachhangActivity.class));
            }
        });
    }

    private void setControl() {
        img = findViewById(R.id.imgviewrundraw);

    }
}
