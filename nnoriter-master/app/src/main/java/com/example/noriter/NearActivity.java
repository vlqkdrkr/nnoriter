package com.example.noriter;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.nhn.android.maps.NMapView;

/**
 * Created by 전효승 on 2018-02-19.
 */

public class NearActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle bundle){
        super.onCreate(bundle);
        getSupportActionBar().setTitle("가까운 PC방");
        setContentView(R.layout.near);
        callmap();
        Intent intent = getIntent();
    }

    private void callmap() {
        Fragment1 fragment1 = new Fragment1();
        fragment1.setArguments(new Bundle());
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.near_nmapview, fragment1);
        fragmentTransaction.commit();
    }
}
