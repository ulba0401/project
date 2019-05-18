package com.example.networkdic.intro;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ProgressBar;

import com.example.networkdic.MainActivity;
import com.example.networkdic.R;

public class IntroPage extends AppCompatActivity {

    ProgressBar progressBar;
    Handler handler = new Handler(){};

    int value = 0; // progressBar 값
    int add = 4; // 증가량, 방향

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page); //xml , java 소스 연결

        progressBar = findViewById(R.id.progressBar_intro);

        handler.sendEmptyMessage(0);

        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                startActivity(intent); //다음화면으로 넘어감
                finish();
            }
        },3000); //3초 뒤에 Runner객체 실행하도록 함




        final ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar_intro);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() { // Thread 로 작업할 내용을 구현
                while(true) {
                    value = value + add;

                    handler.post(new Runnable() {
                        @Override
                        public void run() { // 화면에 변경하는 작업을 구현
                            pb.setProgress(value);
                        }
                    });

                    try {
                        Thread.sleep(100); // 시간지연
                    } catch (InterruptedException e) {    }
                } // end of while
            }
        });
        t.start(); // 쓰레드 시작


    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
