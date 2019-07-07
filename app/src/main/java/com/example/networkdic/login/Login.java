package com.example.networkdic.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.networkdic.BackPressCloseHandler;
import com.example.networkdic.MainActivity;
import com.example.networkdic.R;


public class Login extends AppCompatActivity {
    Button loginBtn;
    TextView joinBtn;

    private static final String TAG = "";
    FragmentPagerAdapter adapterViewpager;
    ImageView main_img;
    private BackPressCloseHandler bc;
    CheckBox checkBtn;
    TextView checkTxt;
    int check = 0;

    private boolean saveLoginData;
    private String email;
    private String name;

    private TextView email_info;
    private TextView name_info;

    private SharedPreferences appData;

    private EditText id, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        checkBtn = findViewById(R.id.checkBtn);
        checkTxt = findViewById(R.id.checkTxt);

        id = findViewById(R.id.login_id);
        pw = findViewById(R.id.login_pw);


        //자동로그인버튼
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBtn.isChecked()) {
                    check = 1;
                    checkTxt.setTextColor(getResources().getColor(R.color.commonColor));
                }else{
                    check = 0;
                    checkTxt.setTextColor(getResources().getColor(R.color.darkgray));
                }
            }
        });



        loginBtn = findViewById(R.id.login_btn);
        joinBtn = findViewById(R.id.join_btn);

        //로그인처리
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그인 비밀번호 아이디 공백시 다시 입력받게
                if(id.getText().toString().length()==0 || pw.getText().toString().length()==0){
                    Toast.makeText(Login.this, "아이디와 비밀번호는 필수사항입니다.", Toast.LENGTH_SHORT).show();
                    if(id.getText().toString().length()==0 ){
                        id.requestFocus();
                    }else{pw.requestFocus();}
                    return;
                }

                LoginRequest request = new LoginRequest(id.getText().toString(), pw.getText().toString(), getApplicationContext());
                try {
                    int check = request.execute().get();
                    if(check == 0){
                        Toast.makeText(Login.this, "아이디와 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                    }else{
                        MainActivity.logout_check = false;
                        String email = LoginRequest.vo.getEmail();
                        String name = LoginRequest.vo.getName();
                        String admin=LoginRequest.vo.getAdmin();
                        Log.d("idCheck",email);
                        Log.d("nameCheck",name);
                        Log.d("adminCheck",admin);
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //회원가입 화면으로 이동
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Join.class);
                startActivity(intent);
            }
        });
    }

    public void save(){
        // SharedPreferences 객체만으론 저장 불가능 Editor 사용
        SharedPreferences.Editor editor = appData.edit();

        // 에디터객체.put타입( 저장시킬 이름, 저장시킬 값 )
        // 저장시킬 이름이 이미 존재하면 덮어씌움

        editor.putBoolean("SAVE_LOGIN_DATA", checkBtn.isChecked());
        editor.putString("NAME", LoginRequest.vo.getName());
        editor.putString("EMAIL", LoginRequest.vo.getEmail());

        // apply, commit 을 안하면 변경된 내용이 저장되지 않음
        editor.apply();
    }

    /*
    //해시키 받기
    public static String getKeyHash(final Context context) {

        PackageInfo packageInfo = getPackageInfo(context, PackageManager.GET_SIGNATURES);
        if (packageInfo == null)
            return null;

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                return android.util.Base64.encodeToString(md.digest(), android.util.Base64.NO_WRAP);
            } catch (NoSuchAlgorithmException e) {
                Log.w(TAG, "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
        return null;
    }
    */
}
