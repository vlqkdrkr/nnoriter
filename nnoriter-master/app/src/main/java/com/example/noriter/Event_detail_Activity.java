package com.example.noriter;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by 전효승 on 2018-03-10.
 */

public class Event_detail_Activity extends AppCompatActivity{
    private int eventindex;

    @Override
    protected void onCreate(Bundle bundle) {

        super.onCreate(bundle);
        getSupportActionBar().setTitle("이벤트 정보");
        setContentView(R.layout.detail_event);

        Intent intent = getIntent();
        eventindex = intent.getIntExtra("index",0);

        ImageView event_image = (ImageView)findViewById(R.id.detail_event_imageview);
        TextView writer = (TextView) findViewById(R.id.detail_event_writer);
        TextView date = (TextView) findViewById(R.id.detail_event_date);

        if(eventindex == 0){

        }

        else{
            event_image.setBackground(getDrawable(R.drawable.event_1));
            writer.setText("제노PC 용두점");
            date.setText("2018-03-13");
        }

        //eventindex를 이용해 데이터베이스를 불러오고 정보를 띄움
    }
}
