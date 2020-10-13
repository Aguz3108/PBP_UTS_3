package com.example.uts_pbp;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class Motor {
    public String merk;
    public String jenis;
    public String kondisi;
    public String tahun;
    public String harga;
    public String foto;

    public Motor(String merk, String jenis, String kondisi, String tahun, String harga, String foto) {
        this.merk = merk;
        this.jenis = jenis;
        this.kondisi = kondisi;
        this.tahun = tahun;
        this.harga = harga;
        this.foto = foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public String getKondisi() {
        return kondisi;
    }

    public String getTahun() { return tahun;}

    public String getHarga() {
        return harga;
    }

    public String getMerk() {
        return merk;
    }

    public String getJenis() {
        return jenis;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    @BindingAdapter("profileImages")
    public static void loadImage(ImageView view, String foto){
        Glide.with(view.getContext())
                .load(foto).apply(new RequestOptions().centerCrop())
                .into(view);
    }

}
