package com.example.lifeguard_rescue_app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DPActivity extends AppCompatActivity {

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.drowning_popup);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
    }

    // 구조 버튼 클릭
    public void mRsc(View v){
        finish();
    }
    // 지원 요청 버튼 클릭
    public void mSpt(View v){
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        // 바깥 레이어 클릭 시 안 닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return  true;
    }
    public void onBackPressed(){
        return;
    }

}
