package com.example.uts_pbp.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.uts_pbp.Model.Customer;

@Database(entities = {Customer.class}, version = 1)
public abstract class CustomerDatabase extends RoomDatabase {
    public abstract CustomerDAO customerDAO();

}
