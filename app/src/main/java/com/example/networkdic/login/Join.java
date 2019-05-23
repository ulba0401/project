package com.example.networkdic.login;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


import com.example.networkdic.R;

import java.util.regex.Pattern;

public class Join extends AppCompatActivity {

    Button submit_btn, cancel_btn;
    EditText id, pw, pwc, email;
    Spinner email_select;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_activity);

        submit_btn = findViewById(R.id.submit);
        cancel_btn = findViewById(R.id.cancel);
        id = findViewById(R.id.join_id);
        pw = findViewById(R.id.join_pw);
        pwc = findViewById(R.id.join_pwc);
        email = findViewById(R.id.email);
        email_select = findViewById(R.id.email_select);

        ArrayAdapter<?> spinner_custom = ArrayAdapter.createFromResource(this, R.array.email, R.layout.spinner_item);
        spinner_custom.setDropDownViewResource(R.layout.spinner_dropdown_item);
        email_select.setAdapter(spinner_custom);


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //회원가입 처리
                if (id.getText().toString().length() == 0){
                    Toast.makeText(Join.this, "아이디를 확인해 주세요", Toast.LENGTH_SHORT).show();
                    id.requestFocus();
                    return;
                }else if (pw.getText().toString().length() == 0||!Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,20}$", pw.getText().toString())){
                    Toast.makeText(Join.this, "비밀번호를 확인해 주세요", Toast.LENGTH_SHORT).show();
                    pw.requestFocus();
                    return;
                }else if(pwc.getText().toString().length()==0){
                    Toast.makeText(Join.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    pwc.requestFocus();
                    return;
                }

            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
