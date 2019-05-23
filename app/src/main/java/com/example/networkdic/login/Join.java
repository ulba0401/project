package com.example.networkdic.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.util.Patterns;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.networkdic.task.common.CommonMethod.isNetworkConnected;

public class Join extends AppCompatActivity {

    Button submit_btn, cancel_btn;
    EditText id, pw, pwc, email;
    Spinner email_select;
    ToggleButton check_btn;
    TextView check_txt;
    int check = 0;


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
        check_btn = findViewById(R.id.check);
        check_txt = findViewById(R.id.check_t);


        //하이퍼링크 걸기
        check_txt.setText("본인이 만 14세 이상인 것과 서비스 이용약관, 개인정보 수집 및 이용 동의, 개인정보 처리방침에 동의 하십니까?");

        Linkify.TransformFilter filter = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher match, String url) {
                return "";
            }
        };

        Pattern pattern1 = Pattern.compile("서비스 이용약관");
        Pattern pattern2 = Pattern.compile("개인정보 수집 및 이용 동의");
        Pattern pattern3 = Pattern.compile("개인정보 처리방침");

        Linkify.addLinks(check_txt, pattern1, "https://www.kiat.or.kr/site/contents/member/index4.jsp?menuID=001006004", null, filter);
        Linkify.addLinks(check_txt, pattern2, "https://www.realtyprice.kr:447/notice/town/popInsertPersonal.search", null, filter);
        Linkify.addLinks(check_txt, pattern3, "https://www.realtyprice.kr:447/notice/popup/personalPrivacy.htm", null, filter);


        //약관동의 체크버튼
        check_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (check_btn.isChecked()) {
                check = 1;
                check_btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.check_on));
                check_txt.setTextColor(getResources().getColor(R.color.commonColor));
            }else{
                check = 0;
                check_btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.check_off));
                check_txt.setTextColor(getResources().getColor(R.color.darkgray));
            }
            }
        });

        //spinner 목록 선택시 값저장


        //spinner 디자인 적용
        ArrayAdapter<?> spinner_custom = ArrayAdapter.createFromResource(this, R.array.email, R.layout.spinner_item);
        spinner_custom.setDropDownViewResource(R.layout.spinner_dropdown_item);
        email_select.setAdapter(spinner_custom);

        //회원가입 처리 및 가입가능 확인
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //회원가입 처리
                if (id.getText().toString().length() == 0) {
                    Toast.makeText(Join.this, "아이디를 확인해 주세요", Toast.LENGTH_SHORT).show();
                    id.requestFocus();
                    return;
                } else if (pw.getText().toString().length() == 0 || !Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,20}$", pw.getText().toString())) {
                    Toast.makeText(Join.this, "비밀번호를 확인해 주세요", Toast.LENGTH_SHORT).show();
                    pw.requestFocus();
                    return;
                } else if (pwc.getText().toString().length() == 0) {
                    Toast.makeText(Join.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    pwc.requestFocus();
                    return;
                } else if (email.getText().toString().length() == 0 || !Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                    Toast.makeText(Join.this, "이메일을 확인해주세요.", Toast.LENGTH_SHORT).show();
                    email.requestFocus();
                    return;
                } else if (email_select.getSelectedItem().toString().equals("이메일을 선택해주세요")) {
                    Toast.makeText(Join.this, "이메일을 선택해주세요.", Toast.LENGTH_SHORT).show();
                    email.requestFocus();
                    return;
                } else if (check == 0) {
                    Toast.makeText(Join.this, "필수약관에 동의해주세요", Toast.LENGTH_SHORT).show();
                    pwc.requestFocus();
                    return;
                }

                if (isNetworkConnected(Join.this) == true) {
                    /* 회원가입 처리할 부분 */
                    String jid = id.getText().toString();
                    String jpw = pw.getText().toString();
                    String jemail = email.getText().toString() + "@" + email_select.getSelectedItem().toString();
                    //아이디 중복체크 처리
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
