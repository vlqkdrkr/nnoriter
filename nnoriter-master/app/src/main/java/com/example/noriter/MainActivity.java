package com.example.noriter;
//http://angrytools.com/android/button/

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

//네이버 지도 클라이언트 ID : CszUaxqSM37gzrSc6sdK 비밀번호 : nuHFbflGsD
//adMob ID : 앱 ID: ca-app-pub-6857486624843975~1445382532

public class MainActivity extends AppCompatActivity {
    private SharedPreferences ad;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.action_bar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        setContentView(R.layout.activity_main);


        ad = getSharedPreferences("ad",MODE_PRIVATE);
        id = ad.getString("id","");


        //버튼 활성화
        Button searchButton = (Button) findViewById(R.id.serach);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SearchActivity.class );
                startActivity(intent);
            }
        });
        Button favoritesButton = (Button) findViewById(R.id.favorites);
        favoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FavoritesActivity.class );
                startActivity(intent);
            }
        });
        Button nearButton = (Button) findViewById(R.id.near);
        nearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NearActivity.class );
                startActivity(intent);
            }
        });
        Button eventButton = (Button) findViewById(R.id.event);
        eventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EventActivity.class );
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        if(id.length() !=0){
            menu.getItem(0).setVisible(true);
            menu.getItem(0).setEnabled(false);
            menu.getItem(0).setTitle(id);
            menu.getItem(1).setVisible(false);
            menu.getItem(3).setVisible(true);
        }
        else{
            menu.getItem(0).setVisible(false);
            menu.getItem(1).setVisible(true);
            menu.getItem(3).setVisible(false);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.user_signup:
                startActivity(new Intent(this, signupActivity.class));
                return true;
            case R.id.user_signin:
                startActivity(new Intent(this,signinActivity.class));
                return true;
            case R.id.main_menu_logout:
                SharedPreferences.Editor editor = ad.edit();
                editor.putString("id","");
                editor.apply();
                startActivity(new Intent(this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
