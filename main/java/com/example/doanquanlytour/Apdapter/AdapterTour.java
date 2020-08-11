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


import com.example.doanquanlytour.DataModels.Tour;
import com.example.doanquanlytour.R;

import java.util.ArrayList;

public class AdapterTour extends ArrayAdapter<Tour> {
        Context context;
        ArrayList<Tour> data;
    ArrayList<Tour> data_ds;
    int resource;

    public AdapterTour(@NonNull Context context, int resource, ArrayList<Tour> data) {
        super(context, resource, data);
        this.context = context;
        this.data = data;
        this.resource = resource;
        this.data_ds = new ArrayList<Tour>();
        this.data_ds.addAll(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }
    private static class ViewHolder{
        ImageView imgTour;
        TextView tvMaTour;
        TextView tvLoTrinh;
        TextView tvHanhTrinh;
        TextView tvGiaTour;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_tour,parent,false);

            mViewHolder.tvMaTour = convertView.findViewById(R.id.txtMaTour);
            mViewHolder.tvLoTrinh = convertView.findViewById(R.id.txtLoTrinh);
            mViewHolder.tvHanhTrinh = convertView.findViewById(R.id.txtHanhTrinh);
            mViewHolder.tvGiaTour = convertView.findViewById(R.id.txtGiaTour);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        final Tour tour = data.get(position);

        mViewHolder.tvMaTour.setText(tour.getMaTour());
        mViewHolder.tvLoTrinh.setText(tour.getLoTrinh());
        mViewHolder.tvHanhTrinh.setText(tour.getHanhTrinh());
        mViewHolder.tvGiaTour.setText(tour.getGiaTour());

        return convertView;
    }

}
