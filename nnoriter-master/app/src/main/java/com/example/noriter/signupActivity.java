package com.example.noriter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {
    private String id;
    private String pw1;
    private String pw2;
    private String email;
    private boolean check = true;
    private boolean idcheck = false;

    @Override
    protected void onCreate(@Nullable Bundle bundle){
        super.onCreate(bundle);
        getSupportActionBar().setTitle("회원가입");
        setContentView(R.layout.sign_up);

        final EditText id_et = (EditText) findViewById(R.id.sign_up_id);
        final EditText pw1_et = (EditText) findViewById(R.id.sign_up_password1);
        final EditText pw2_et = (EditText) findViewById(R.id.sign_up_password2);
        final EditText email_et = (EditText) findViewById(R.id.sign_up_email);
        Button sign_up_button = (Button) findViewById(R.id.sign_up_signup);

        //가입하기 버튼
        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id  = id_et.getText().toString();
                pw1 = pw1_et.getText().toString();
                pw2 = pw2_et.getText().toString();
                email = email_et.getText().toString();

                //id가 입력되지 않은 경우
                if(id.length() == 0){
                    id_et.setBackgroundResource(R.color.warring);
                    check = false;
                }

                //id가 있을경우
                if(idcheck) {
                    check = false;
                }
                //비밀번호가 입력되지 않은경우
                if(pw1.length() == 0){
                    pw1_et.setBackgroundResource(R.color.warring);
                    check = false;
                }
                if(pw2.length() == 0){
                    pw2_et.setBackgroundResource(R.color.warring);
                    check = false;
                }
                //비밀번호가 다를경우
                if(!pw1.equals(pw2)){
                    pw1_et.setBackgroundResource(R.color.warring);
                    pw2_et.setBackgroundResource(R.color.warring);
                    check = false;
                }
                else if (pw1.length() != 0){
                    pw1_et.setBackgroundResource(R.color.singup1);
                    pw2_et.setBackgroundResource(R.color.singup1);
                    check = true;
                }

                //email이 입력되지 않은 경우
                if(email.length() == 0){
                    email_et.setBackgroundResource(R.color.warring);
                    check = false;
                }

                if(check){//회원가입 성공
                    Toast.makeText(signupActivity.this, "회원가입 성공!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }
        });
        edittextevent(id_et);
        edittextevent(pw1_et);
        edittextevent(pw2_et);
        edittextevent(email_et);


        //데베 서버 연동

    }
    public void edittextevent(final EditText edit){
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edit.setBackgroundResource(R.color.singup1);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                edit.setBackgroundResource(R.color.singup1);
            }
        });
    }
}

