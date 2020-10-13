package com.example.uts_pbp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.AsyncTask;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uts_pbp.Database.CustomerClient;
import com.example.uts_pbp.Adapter.CustomerRecyclerViewAdapter;
import com.example.uts_pbp.Model.Customer;

import android.os.Bundle;

import java.util.List;

public class CustomerActivity extends AppCompatActivity {
    private Button addCustomer, editCustomer;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        addCustomer = findViewById(R.id.addCustomer);
        refreshLayout = findViewById(R.id.swipe_refresh);
        recyclerView = findViewById(R.id.list_customer);
        editCustomer = findViewById(R.id.editCustomer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getCustomer();


        addCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Bundle data = new Bundle();
                addCustomer.setVisibility(View.GONE);
                AddCustomer addCustomer = new AddCustomer();
                addCustomer.setArguments(data);
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.layout_customer, addCustomer)
                        .commit();
            }
        });

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getCustomer();
                refreshLayout.setRefreshing(false);
            }
        });
        getCustomer();

        editCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent int = new Intent(this, EditCustomer.class);
//                startActivity(int);
            }
        });
    }

    private void getCustomer(){
        class addCustomer extends AsyncTask<Void, Void, List<Customer>>{

            @Override
            protected List<Customer> doInBackground(Void... voids){
                List<Customer> customerList = CustomerClient
                        .getInstance(getApplicationContext())
                        .getDatabase()
                        .customerDAO()
                        .getAll();
                return customerList;
            }

            @Override
            protected void onPostExecute(List<Customer> customers){
                super.onPostExecute(customers);
                CustomerRecyclerViewAdapter adapter = new CustomerRecyclerViewAdapter(CustomerActivity.this, customers);
                recyclerView.setAdapter(adapter);
                if(customers.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Empty Customers", Toast.LENGTH_SHORT).show();
                }
            }
        }
        addCustomer add = new addCustomer();
        add.execute();
    }


}