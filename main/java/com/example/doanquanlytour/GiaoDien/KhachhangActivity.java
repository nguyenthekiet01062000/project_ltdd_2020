package com.example.doanquanlytour.GiaoDien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.doanquanlytour.Apdapter.AdapterKhachHang;
import com.example.doanquanlytour.DataModels.KhachHang;
import com.example.doanquanlytour.Database.DBKhachHang;
import com.example.doanquanlytour.R;

import java.util.ArrayList;

public class KhachhangActivity extends AppCompatActivity {
    EditText txtMaKH,txtTenKH,txtDiaChi;
    Button btnThem, btnXoa,btnSua,btnClear;
    ListView lvDanhSach;

    AdapterKhachHang adapterKhachHang;
    ArrayList<KhachHang> data_KhachHang = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khachhang);
        setControl();
        setEvent();
    }

    private void setEvent() {
        hienthidulieuKH();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBKhachHang dbKhachHang = new DBKhachHang(KhachhangActivity.this);
                KhachHang kh = new KhachHang();
                kh.setMaKH(txtMaKH.getText().toString());
                kh.setTenKH(txtTenKH.getText().toString());
                kh.setDiaChi(txtDiaChi.getText().toString());
                dbKhachHang.Them(kh);
                hienthidulieuKH();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBKhachHang dbKhachHang = new DBKhachHang(KhachhangActivity.this);
                KhachHang kh = new KhachHang();
                kh.setMaKH(txtMaKH.getText().toString());
                kh.setTenKH(txtTenKH.getText().toString());
                kh.setDiaChi(txtDiaChi.getText().toString());
                dbKhachHang.Xoa(kh);
                hienthidulieuKH();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBKhachHang dbKhachHang = new DBKhachHang(KhachhangActivity.this);
                KhachHang kh = new KhachHang();
                kh.setMaKH(txtMaKH.getText().toString());
                kh.setTenKH(txtTenKH.getText().toString());
                kh.setDiaChi(txtDiaChi.getText().toString());
                dbKhachHang.Sua(kh);
                hienthidulieuKH();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMaKH.setText("");
                txtTenKH.setText("");
                txtDiaChi.setText("");

            }
        });

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                KhachHang kh = data_KhachHang.get(position);
                txtMaKH.setText(kh.getMaKH());
                txtTenKH.setText(kh.getTenKH());
                txtDiaChi.setText(kh.getDiaChi());

            }
        });
    }

    private void hienthidulieuKH() {
        DBKhachHang dbKhachHang = new DBKhachHang(this);

        data_KhachHang = dbKhachHang.LayDL();
        adapterKhachHang = new AdapterKhachHang(this,R.layout.item_list_khachhang,data_KhachHang);
        lvDanhSach.setAdapter(adapterKhachHang);
    }
    private void setControl() {
        txtMaKH = findViewById(R.id.txtMaKH);
        txtTenKH = findViewById(R.id.txtTenKH);
        txtDiaChi = findViewById(R.id.txtDiaChi);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        btnClear = findViewById(R.id.btnClear);
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }
}
