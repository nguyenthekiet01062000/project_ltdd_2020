package com.example.doanquanlytour.Apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doanquanlytour.DataModels.KhachHang;
import com.example.doanquanlytour.DataModels.Tour;
import com.example.doanquanlytour.R;


import java.util.ArrayList;

public class AdapterKhachHang extends ArrayAdapter<KhachHang> {
    Context context;
    ArrayList<KhachHang> dataKH;
    ArrayList<KhachHang> data_dsKH;
    int resource;

    public AdapterKhachHang(@NonNull Context context, int resource, ArrayList<KhachHang> data) {
        super(context, resource, data);
        this.context = context;
        this.dataKH = data;
        this.resource = resource;
        this.data_dsKH = new ArrayList<KhachHang>();
        this.data_dsKH.addAll(data);
    }

    @Override
    public int getCount() {
        return dataKH.size();
    }
    private static class ViewHolder{
        ImageView imgKhachHang;
        TextView tvMaKH;
        TextView tvTenKH;
        TextView tvDiaChi;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AdapterKhachHang.ViewHolder mViewHolder = new AdapterKhachHang.ViewHolder();
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_khachhang,parent,false);

            mViewHolder.tvMaKH = convertView.findViewById(R.id.txtMaKH);
            mViewHolder.tvTenKH = convertView.findViewById(R.id.txtTenKH);
            mViewHolder.tvDiaChi = convertView.findViewById(R.id.txtDiaChi);


            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (AdapterKhachHang.ViewHolder) convertView.getTag();
        }
        final KhachHang kh = dataKH.get(position);

        mViewHolder.tvMaKH.setText(kh.getMaKH());
        mViewHolder.tvTenKH.setText(kh.getTenKH());
        mViewHolder.tvDiaChi.setText(kh.getDiaChi());


        return convertView;
    }

}
