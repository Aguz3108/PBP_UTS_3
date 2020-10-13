package com.example.uts_pbp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.uts_pbp.Database.CustomerClient;
import com.example.uts_pbp.Model.Customer;
import com.google.android.material.textfield.TextInputEditText;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.Objects;

public class EditCustomer extends Fragment {

    Button btnBack, btnSubmit;
    EditText editNama, editAlamat, editNomortelepon, editNomorktp, editSewa;
    String addNama, addAlamat, addNomortelepon, addNomorktp, addSewa;
    ImageView addImage;
    Customer cus;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public EditCustomer() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_customer, container, false);
        //cus = (Customer) getArguments().getSerializable("customer");
        editNama = view.findViewById(R.id.inputName);
        editAlamat = view.findViewById(R.id.inputAddress);
        editNomortelepon = view.findViewById(R.id.inputPhoneNumber);
        editNomorktp = view.findViewById(R.id.inputCitizenNumber);
        editSewa = view.findViewById(R.id.inputRent);
        addImage = view.findViewById(R.id.addImage);
        btnBack = view.findViewById(R.id.btnBack);
        btnSubmit = view.findViewById(R.id.btnSubmit);

//        editNama.setText(cus.getNama());
//        editAlamat.setText(cus.getAlamat());
//        editNomortelepon.setText(cus.getNomortelepon());
//        editNomorktp.setText(cus.getNomorktp());
//        editSewa.setText(cus.getSewa());

        return inflater.inflate(R.layout.fragment_edit_customer, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(EditCustomer.this).commit();

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cus.setNama(editNama.getText().toString());
                cus.setAlamat(editAlamat.getText().toString());
                cus.setNomortelepon(Integer.parseInt(editNomortelepon.getText().toString()));
                cus.setNomorktp(Integer.parseInt(editNomorktp.getText().toString()));
                cus.setSewa(Integer.parseInt(editSewa.getText().toString()));
                update(cus);

            }
        });


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        addImage.setOnClickListener(view1 -> {
            CropImage.activity()
                    .setActivityTitle("Pilih Foto")
                    .setAllowFlipping(false)
                    .setCropMenuCropButtonTitle("Selesai")
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .start(requireContext(), this);
        });
    }

    private void update(final Customer customer){
        class updateCustomer extends AsyncTask<Void, Void, Void>{

            @Override
            protected Void doInBackground(Void... voids){

                CustomerClient.getInstance(getActivity().getApplicationContext()).getDatabase()
                            .customerDAO()
                            .update(customer);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid){
                super.onPostExecute(aVoid);
                Toast.makeText(getActivity().getApplicationContext(), "Booking Edited", Toast.LENGTH_SHORT).show();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(EditCustomer.this).commit();
            }
        }

        updateCustomer update = new updateCustomer();
        update.execute();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CropImage.ActivityResult result = CropImage.getActivityResult(data);
        if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Log.e("RESULT", result.getUri().toString());
        } else {
            Log.e("EROR", result.getError().toString());
        }
    }
}