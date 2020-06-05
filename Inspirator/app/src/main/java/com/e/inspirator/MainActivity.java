package com.e.inspirator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //private String [] dataMenu= {"agung","kevin","aulion","ronaldo","gusdur"};
    private MenuAdapter adapter;
    private String[] dataNama;
    private String[] dataDes;
    private TypedArray dataGambar;
    private ArrayList<Menu> menus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvlist= findViewById(R.id.lv_list);
        adapter=new MenuAdapter(this);
        lvlist.setAdapter(adapter);

        prepare();
        tambahitem();

        lvlist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // Toast.makeText(MainActivity.this,menus.get(i).getNama(),Toast.LENGTH_SHORT).show();
                Intent pindahdata= new Intent(MainActivity.this, DetailActivity.class);
                pindahdata.putExtra(DetailActivity.datanama,menus.get(i).getNama());
                pindahdata.putExtra(DetailActivity.datadeskripsi,menus.get(i).getDeskripsi());
                pindahdata.putExtra(DetailActivity.datagambar,menus.get(i).getGambar());
                startActivity(pindahdata);


            }
        });
    }
    private void prepare(){
        dataNama=getResources().getStringArray(R.array.data_menu);
        dataDes=getResources().getStringArray(R.array.data_deskripsi);
        dataGambar=getResources().obtainTypedArray(R.array.data_gambar);

    }
    private void tambahitem(){
        menus = new ArrayList<>();

        for (int i=0; i<dataNama.length; i++){
            Menu menu = new Menu();
            menu.setGambar(dataGambar.getResourceId(i, -1));
            menu.setNama(dataNama[i]);
            menu.setDeskripsi(dataDes[i]);
            menus.add(menu);
        }
        adapter.setMenus(menus);
    }
}
