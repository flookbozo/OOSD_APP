package com.example.oosd_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oosd_app.R;
import com.example.oosd_app.model.IllegalCar;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHodler> {

    private Context mContext;
    private int mResource;
    private List<IllegalCar> mCarList;

    public RecyclerViewAdapter(Context mContext, int mResource, List<IllegalCar> mCarList) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mCarList = mCarList;
    }

    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        return new MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodler holder, int position) {
        IllegalCar car = mCarList.get(position);

        holder.car = car;
        holder.numberTextView.setText(car.numberCar);
    }

    @Override
    public int getItemCount() {
        return mCarList.size();
    }

    class MyViewHodler extends RecyclerView.ViewHolder {
        private TextView numberTextView;

        private IllegalCar car;

        public MyViewHodler(@NonNull View itemView) {
            super(itemView);
            this.numberTextView = itemView.findViewById(R.id.number_text_view);
        }
    }
}
