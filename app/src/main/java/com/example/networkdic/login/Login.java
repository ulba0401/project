package com.example.networkdic.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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
    ToggleButton checkBtn;
    TextView checkTxt;
    int check = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        //자동로그인버튼
        checkBtn = findViewById(R.id.checkBtn);
        checkTxt = findViewById(R.id.checkTxt);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBtn.isChecked()) {
                    check = 1;
                    checkBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.check_on));
                    checkTxt.setTextColor(getResources().getColor(R.color.commonColor));
                }else{
                    check = 0;
                    checkBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.check_off));
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
