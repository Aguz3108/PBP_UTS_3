package com.example.uts_pbp.Database;

import android.content.Context;

import androidx.room.Room;
public class CustomerClient {

    private Context context;
    private static CustomerClient client;

    private CustomerDatabase database;

    private CustomerClient(Context context){
        this.context = context;
        database = Room.databaseBuilder(context, CustomerDatabase.class, "customer").build();
    }

    public static synchronized  CustomerClient getInstance(Context context){
        if(client == null){
            client = new CustomerClient(context);
        }
        return client;
    }

    public CustomerDatabase getDatabase(){
        return database;
    }

}
