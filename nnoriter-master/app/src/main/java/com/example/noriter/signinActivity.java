package com.example.noriter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signinActivity extends AppCompatActivity {
    private String id;
    private String pw;
    private boolean check = true;
    private SharedPreferences ad;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("로그인");
        setContentView(R.layout.sign_in);
        ad = getSharedPreferences("ad",MODE_PRIVATE);

        final EditText id_et = (EditText) findViewById(R.id.sign_in_id);
        final EditText pw_et = (EditText) findViewById(R.id.sign_in_password1);

        Button log_in = (Button) findViewById(R.id.sign_in_signin);
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id  = id_et.getText().toString();
                pw = pw_et.getText().toString();

                //id가 존재하지 않는 경우
                if(id!=id){

                    check=false;
                }
                //pw가 틀린 경우
                if(pw!=pw){

                    check=false;
                }
                if(check){
                    Toast.makeText(signinActivity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = ad.edit();
                    editor.putString("id",id);
                    editor.apply();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }
        });
    }
}
