package com.example.noriter;

        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.drawable.BitmapDrawable;
        import android.graphics.drawable.Drawable;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.os.Handler;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentTransaction;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.ExpandableListView;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.ListView;
        import android.widget.PopupWindow;
        import android.widget.RelativeLayout;
        import android.widget.TabHost;
        import android.widget.TextView;
        import android.widget.Toast;


        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
        import org.w3c.dom.Text;

        import java.io.BufferedReader;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.util.ArrayList;

/**
 * Created by 전효승 on 2018-03-05.
 */

public class pcinfoActivity extends AppCompatActivity {

    private PopupWindow popup_review;
    private int index;
    String myJSON;
    private static final String TAG_RESULTS = "result";

    JSONArray peoples = null;
    String name;
    String Pc_name;
    String Pc_number;
    String Pc_address;
    int Pc_Card;
    int Pc_Printer;
    int Pc_Office;
    int Pc_Charger;
    String Pc_CPU;
    String Pc_GPU;
    int Pc_RAM;
    String Pc_Pc_main;
    String Pc_PC_menu;
    double lo_x;
    double lo_y;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        getSupportActionBar().setTitle("PC방 정보");
        setContentView(R.layout.pcinfo2);
        //final TextView name = (TextView) findViewById(R.id.pcinfo_name);
        Intent intent = getIntent();
        Pc_name = intent.getStringExtra("name");
        Pc_number = intent.getStringExtra("number");
        Pc_address = intent.getStringExtra("address");
        Pc_Card = intent.getIntExtra("Card",0);
        Pc_Printer = intent.getIntExtra("Printer",0);
        Pc_Office = intent.getIntExtra("Office",0);
        Pc_Charger = intent.getIntExtra("Charger",0);
        Pc_CPU = intent.getStringExtra("CPU");
        Pc_GPU = intent.getStringExtra("GPU");
        Pc_RAM = intent.getIntExtra("RAM",0);
        Pc_Pc_main = intent.getStringExtra("Pc_main");
        Pc_PC_menu = intent.getStringExtra("PC_menu");
        lo_x=intent.getDoubleExtra("lo_x",0);
        lo_y=intent.getDoubleExtra("lo_y",0);
        TextView nameTextView = (TextView) findViewById(R.id.pcinfo_name);
        TextView numberTextView = (TextView) findViewById(R.id.pcinfo_number);
        TextView addressTextView = (TextView) findViewById(R.id.pcinfo_address);
        TextView CPUTextView = (TextView) findViewById(R.id.pcinfo_CPU);
        TextView GPUTextView = (TextView) findViewById(R.id.pcinfo_GPU);
        TextView RAMTextView = (TextView) findViewById(R.id.pcinfo_RAM);
        nameTextView.setText(Pc_name);
        numberTextView.setText(Pc_number);
        addressTextView.setText(Pc_address);
        CPUTextView.setText(Pc_CPU);
        GPUTextView.setText(Pc_GPU);
        RAMTextView.setText(Integer.toString(Pc_RAM)+"GB");

        //ImageView pc_main = (ImageView) findViewById(R.id.mainpcpic) ;
        //pc_main.setBackground(getDrawable(R.drawable.pc_main));
        //index = intent.getIntExtra("index",0);

        //태그 관리
        TagViewAdapter tagAdapter = new TagViewAdapter();
        //RecyclerView TagRecyclerView = (RecyclerView) findViewById(R.id.pcinfo_tagView);
        LinearLayoutManager TagLayoutManager = new LinearLayoutManager(getApplicationContext());
        TagLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //TagRecyclerView.setLayoutManager(TagLayoutManager);
        if(Pc_Card == 1)
            tagAdapter.add(getDrawable(R.drawable.tag_card_on));
        if(Pc_Charger == 1)
            tagAdapter.add(getDrawable(R.drawable.tag_charger_on));
        if(Pc_Office == 1)
            tagAdapter.add(getDrawable(R.drawable.tag_office_on));
        if(Pc_Printer == 1)
            tagAdapter.add(getDrawable(R.drawable.tag_printer_on));
        //TagRecyclerView.setAdapter(tagAdapter);
        tagAdapter.notifyDataSetChanged();

        callmap();
        //Tab 관리
        TabHost tabHost1 = (TabHost) findViewById(R.id.TabHost) ;
        tabHost1.setup() ;

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("con1") ;
        ts1.setContent(R.id.tab1) ;
        ts1.setIndicator("사양") ;
        tabHost1.addTab(ts1) ;

        TabHost.TabSpec ts2 = tabHost1.newTabSpec("con2") ;
        ts2.setContent(R.id.tab2) ;
        ts2.setIndicator("좌석") ;
        tabHost1.addTab(ts2) ;

        TabHost.TabSpec ts3 = tabHost1.newTabSpec("con3") ;
        ts3.setContent(R.id.tab3) ;
        ts3.setIndicator("메뉴") ;
        tabHost1.addTab(ts3) ;

        TabHost.TabSpec ts4 = tabHost1.newTabSpec("con4") ;
        ts4.setContent(R.id.tab4) ;
        ts4.setIndicator("리뷰") ;
        tabHost1.addTab(ts4) ;

        //이미지 관리
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {    // 오래 거릴 작업을 구현한다
                // TODO Auto-generated method stub
                try{
                    // 걍 외우는게 좋다 -_-;
                    final ImageView iv = (ImageView)findViewById(R.id.mainpcpic);
                    URL url = new URL(Pc_Pc_main);
                    InputStream is = url.openStream();
                    final Bitmap bm = BitmapFactory.decodeStream(is);
                    final Drawable d = new BitmapDrawable(bm);
                    handler.post(new Runnable() {

                        @Override
                        public void run() {  // 화면에 그려줄 작업
                            iv.setBackground(d);
                        }
                    });
                } catch(Exception e){

                }

            }
        });

        t.start();

        final ImageButton menu = (ImageButton) findViewById(R.id.pcinfo_menuImage);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), pcinfo_menu.class);
                intent2.putExtra("menu",Pc_PC_menu);
                startActivity(intent2);
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {    // 오래 거릴 작업을 구현한다
                // TODO Auto-generated method stub
                try{
                    // 걍 외우는게 좋다 -_-;
                    final ImageButton iv = (ImageButton)findViewById(R.id.pcinfo_menuImage);
                    URL url = new URL(Pc_PC_menu);
                    InputStream is = url.openStream();
                    final Bitmap bm = BitmapFactory.decodeStream(is);
                    final Drawable d = new BitmapDrawable(bm);
                    handler.post(new Runnable() {

                        @Override
                        public void run() {  // 화면에 그려줄 작업
                            iv.setBackground(d);
                        }
                    });
                    iv.setBackground(d);
                } catch(Exception e){

                }

            }
        });
        t1.start();


        Button MakeReview = (Button) findViewById(R.id.pcinfo_review_make);
        MakeReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View popupview_local = getLayoutInflater().inflate(R.layout.pcinfo_review_make,null);
                popup_review = new PopupWindow(popupview_local, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                popup_review.setFocusable(true);
                popup_review.setAnimationStyle(-1);
                popup_review.showAtLocation(popupview_local, Gravity.CENTER,0,0);
            }
        });

        //리뷰 리스트뷰 세팅
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.pcinfo_reviewlist);
        final review_expandablelistview_adapter adapter= new review_expandablelistview_adapter();
        listView.setAdapter(adapter);

        adapter.addItem(1,1,"액션가면","2018-3-15","아니 이 피시방 도대체","민지는 공부하기가 정말로 싫나봐요, 매우 지쳐서 남자친구에게 계속 기대고 귀찮게 하네요 정말 혼내야 겠어요");
        adapter.addItem(2,1,"짱구","2018-3-15","무엇무엇 도대체","좋아요");
        adapter.addItem(3,1,"철수","2018-3-15","아아 그는","신기해요");
        adapter.addItem(4,1,"영희","2018-3-15","공부하기 싫다","뭔지모르겟어요");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                review_listview_item item = (review_listview_item) parent.getItemAtPosition(position) ;

                int rindex = item.getrindex();
                int pindex = item.getpindex();
            }
        });
    }
    private void callmap() {
        fragment2 frag2 = new fragment2();
        Bundle bundle = new Bundle();
        bundle.putDouble("lo_x",lo_x);
        bundle.putDouble("lo_y",lo_y);
        bundle.putString("name",name);
        frag2.setArguments(bundle);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.info_map, frag2);
        fragmentTransaction.commit();
    }
}
