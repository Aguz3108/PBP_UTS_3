package com.example.uts_pbp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_pbp.DaftarMotor;
import com.example.uts_pbp.Motor;
import com.example.uts_pbp.R;
import com.example.uts_pbp.databinding.ActivityMotorcycleDetailsBinding;

import java.util.List;

public class MotorcycleDetails extends RecyclerView.Adapter<MotorcycleDetails.MyViewHolder> {

    private List<Motor> motor;
    private Context context;;
    ActivityMotorcycleDetailsBinding binding;

    public MotorcycleDetails() {
    }

    public MotorcycleDetails(Context context, List<Motor> motor) {
        this.motor = motor;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.activity_motorcycle_details,parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        motor = new DaftarMotor().MOTOR;
        binding.setMtr(motor.get(position));
    }

    @Override
    public int getItemCount() {
        return motor.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public MyViewHolder(@NonNull ActivityMotorcycleDetailsBinding binding){
            super(binding.getRoot());
        }
        public void onClick(View view) {
            Toast.makeText(context, "You touch me?", Toast.LENGTH_SHORT).show();
        }
    }
}