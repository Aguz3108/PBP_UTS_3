package com.example.uts_pbp.Adapter;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_pbp.Model.Customer;
import com.example.uts_pbp.EditCustomer;
import com.example.uts_pbp.R;

import java.util.List;

public class CustomerRecyclerViewAdapter extends RecyclerView.Adapter<CustomerRecyclerViewAdapter.CusViewHolder>{
    private Context context;
    public List<Customer> customerList;

    public CustomerRecyclerViewAdapter(Context context, List<Customer> customerList) {
        this.context = context;
        this.customerList = customerList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.data_customer, parent, false);
        return new CusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CusViewHolder holder, int position) {
        Customer customer = customerList.get(position);
        holder.txtNama.setText(customer.getNama());
        holder.txtAlamat.setText(customer.getAlamat());
        holder.txtNomorTelepon.setText(customer.getNomortelepon());
        holder.txtNomorKTP.setText(customer.getNomorktp());
        holder.txtSewa.setText(customer.getSewa());
        holder.txtMotor.setText(customer.getMotor());
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public class CusViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtNama, txtAlamat, txtNomorTelepon, txtNomorKTP, txtSewa, txtMotor;

        public CusViewHolder(@NonNull View itemView){
            super(itemView);
            txtNama = itemView.findViewById(R.id.nama);
            txtAlamat = itemView.findViewById(R.id.alamat);
            txtNomorTelepon = itemView.findViewById(R.id.nomortelepon);
            txtNomorKTP = itemView.findViewById(R.id.nomorktp);
            txtMotor = itemView.findViewById(R.id.motor);
            txtSewa = itemView.findViewById(R.id.sewa);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            Customer customer = customerList.get(getAdapterPosition());
            Bundle data = new Bundle();
            data.putSerializable("customer", customer);
            EditCustomer editCustomer = new EditCustomer();
            editCustomer.setArguments(data);
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_customer, editCustomer)
                    .commit();
        }
    }

}
