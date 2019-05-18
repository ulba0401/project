package com.example.networkdic.intro;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ProgressBar;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.example.networkdic.MainActivity;
import com.example.networkdic.R;

public class IntroPage extends AppCompatActivity {

    Handler handler = new Handler(){};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page); //xml , java 소스 연결

        LottieAnimationView animationView = findViewById(R.id.lottieAnimView);
        setUpAnimation(animationView);

        handler.sendEmptyMessage(0);

        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                startActivity(intent); //다음화면으로 넘어감
                finish();
            }
        },3000); //3초 뒤에 Runner객체 실행하도록 함
    }

    private void setUpAnimation(LottieAnimationView animationView) {
        // 재생할 애니메이션 넣어준다.
        animationView.setAnimation("2275-loading-book.json");
        // 반복횟수를 무한히 주고 싶을 땐 LottieDrawable.INFINITE or 원하는 횟수
        animationView.setRepeatCount(LottieDrawable.INFINITE);
        // 시작
        animationView.playAnimation();
    }
}
