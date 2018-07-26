package com.example.noriter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by 전효승 on 2018-02-19.
 */

public class FavoritesActivity extends AppCompatActivity{
    private ArrayList<Integer> favoritespc;
    private SharedPreferences ad;
    private String id;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        getSupportActionBar().setTitle("즐겨찾기");
        setContentView(R.layout.favorites);
        ad = getSharedPreferences("ad",MODE_PRIVATE);
        id = ad.getString("id","");

        Intent intent = getIntent();

        ListView favoriteListView = (ListView) findViewById(R.id.favorites_pclist);
        final ListViewAdapter adapter = (ListViewAdapter) new ListViewAdapter();

        //favorite가 1인 pc방들만 add item
    }
}
