package com.example.networkdic.task.crud;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.networkdic.R;
import com.example.networkdic.vos.DiclistVO;

public class WordDetail extends AppCompatActivity {

    DiclistVO vo;
    TextView abb, full, econtent, kcontent, unit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.word_detail_activity);

        abb = findViewById(R.id.dabb);
        full = findViewById(R.id.dfull);
        econtent = findViewById(R.id.decontent);
        kcontent = findViewById(R.id.dkcontent);
        unit = findViewById(R.id.dunit);

        vo = (DiclistVO) getIntent().getSerializableExtra("vo");

        abb.setText(vo.getAbbword());
        full.setText(vo.getFullname());
        econtent.setText(vo.getExplanation());
        kcontent.setText(vo.getKorword());
        unit.setText(vo.getUnit());
    }
}
