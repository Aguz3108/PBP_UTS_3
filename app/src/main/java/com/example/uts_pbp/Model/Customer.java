package com.example.uts_pbp.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Customer implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nama")
    public String nama;

    @ColumnInfo(name = "alamat")
    public String alamat;

    @ColumnInfo(name = "nomortelepon")
    public int nomortelepon;

    @ColumnInfo(name = "nomorktp")
    public int nomorktp;

    @ColumnInfo(name = "motor")
    public String motor;

    @ColumnInfo(name = "sewa")
    public int sewa;

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getNomortelepon() {
        return nomortelepon;
    }

    public int getNomorktp() {
        return nomorktp;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getMotor() {
        return motor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNomortelepon(int nomortelepon) {
        this.nomortelepon = nomortelepon;
    }

    public void setNomorktp(int nomorktp) {
        this.nomorktp = nomorktp;
    }

    public void setSewa(int sewa) {
        this.sewa = sewa;
    }

    public int getSewa() {
        return sewa;
    }
}
