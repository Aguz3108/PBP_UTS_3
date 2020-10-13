package com.example.uts_pbp;

import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uts_pbp.Database.CustomerClient;
import com.example.uts_pbp.Database.CustomerDatabase;
import com.example.uts_pbp.Model.Customer;
import com.google.android.material.textfield.TextInputEditText;


public class AddCustomer extends Fragment {
    Button btnBack, btnSubmit;
    Customer cus;
    TextInputEditText nama, alamat, nomortelepon, nomorktp, sewa, motor;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public AddCustomer() {
    }

    public static AddCustomer newInstance(String param1, String param2){
        AddCustomer fragment = new AddCustomer();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_customer, container ,false);
        nama = view.findViewById(R.id.inputName);
        alamat = view.findViewById(R.id.inputAddress);
        nomortelepon = view.findViewById(R.id.inputPhoneNumber);
        nomorktp = view.findViewById(R.id.inputCitizenNumber);
        sewa = view.findViewById(R.id.inputRent);
        motor = view.findViewById(R.id.inputMotor);

        btnBack = view.findViewById(R.id.btnBack);
        btnSubmit = view.findViewById(R.id.btnSubmit);

        cus = new Customer();
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(AddCustomer.this).commit();

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cus.setNama(nama.getText().toString());
                cus.setAlamat(alamat.getText().toString());
                cus.setNomortelepon(Integer.parseInt(nomortelepon.getText().toString()));
                cus.setNomorktp(Integer.parseInt(nomorktp.getText().toString()));
                cus.setSewa(Integer.parseInt(sewa.getText().toString()));
                insert(cus);

            }
        });


    }

    private void insert(final Customer customer){
       if(nama.getText().length()==0 || alamat.getText().length()==0 || nomortelepon.getText().length()==0 || nomorktp.getText().length()==0 || sewa.getText().length()==0 || motor.getText().length()==0 ){
            if(nama.getText().length()==0){
                nama.setError("Nama tidak boleh kosong!");
            }
            if(alamat.getText().length()==0){
                alamat.setError("Alamat tidak boleh kosong!");
            }
            if(nomortelepon.getText().length()==0){
                nomortelepon.setError("Nomor telepon tidak boleh kosong!");
            }
            if(nomorktp.getText().length()==0){
                nomorktp.setError("Nomor ktp tidak boleh kosong!");
            }
            if(sewa.getText().length()==0){
                sewa.setError("Sewa tidak boleh kosong!");
            }
            if(motor.getText().length()==0){
                motor.setError("Motor tidak boleh kosong!");
                if(motor.getText().toString() != "Beat" || motor.getText().toString() != "Mio" || motor.getText().toString() != "Scoopy"
                || motor.getText().toString() != "R25" || motor.getText().toString() != "Vixion" || motor.getText().toString() != "Verza"
                || motor.getText().toString() != "DTracker" || motor.getText().toString() != "KLX" || motor.getText().toString() != "KTM"){
                    motor.setError("Motor tidak tersedia!Silahkan cek list motor!");
                }
            }
        }else{
            class InsertCus extends AsyncTask<Void, Void, Void>{

                @Override
                protected Void doInBackground(Void... voids){

                    CustomerClient.getInstance(getActivity().getApplicationContext()).getDatabase()
                            .customerDAO()
                            .insert(customer);
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid){
                    super.onPostExecute(aVoid);
                    Toast.makeText(getActivity().getApplicationContext(), "Customer Added", Toast.LENGTH_SHORT ).show();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.hide(AddCustomer.this).commit();
                }
            }
            InsertCus insert = new InsertCus();
            insert.execute();

        }


    }

}