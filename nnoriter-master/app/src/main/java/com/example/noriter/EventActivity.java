package com.example.noriter;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by 전효승 on 2018-02-19.
 */

public class EventActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        getSupportActionBar().setTitle("이벤트");
        setContentView(R.layout.event);

        ListView listView = (ListView) findViewById(R.id.events);
        final EventListViewAdapter adapter = new EventListViewAdapter();
        listView.setAdapter(adapter);

        adapter.addItem(1,getDrawable(R.drawable.xeno),"제노 용두점 LOL 이벤트","2018-03-28","서울시 왕산로 32길 99");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                EventListViewItem item = (EventListViewItem) parent.getItemAtPosition(position) ;

                int eventindex = item.geteventindex();

                Intent intent = new Intent(getApplicationContext(), Event_detail_Activity.class);
                intent.putExtra("index",eventindex);
                startActivity(intent);
                // TODO : use item data.
            }
        }) ;
    }
}
