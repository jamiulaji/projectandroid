package com.e.inspirator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String datanama="datanama";
    public static final String datadeskripsi="datadeskripsi";
    public static final String datagambar="datagambar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvnama=findViewById(R.id.tv_nama);
        TextView tvDeskripsi=findViewById(R.id.tv_des);
        ImageView imgMenu=findViewById(R.id.iv_menu);

        String simpannama= getIntent().getStringExtra(datanama);

        tvnama.setText(simpannama);
        tvDeskripsi.setText(getIntent().getStringExtra(datadeskripsi));
        imgMenu.setImageResource(getIntent().getIntExtra(datagambar,0));
    }
}
