package com.example.uts_pbp.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.uts_pbp.Model.Customer;

import java.util.List;

@Dao
public interface CustomerDAO {
    @Query("SELECT * FROM customer")
    List<Customer> getAll();

    @Insert
    void insert(Customer customer);

    @Update
    void update(Customer customer);

}
