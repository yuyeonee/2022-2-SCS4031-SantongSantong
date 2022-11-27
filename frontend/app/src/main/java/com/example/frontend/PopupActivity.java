package com.example.frontend;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PopupActivity extends AppCompatActivity {
    private ImageView image;
    private TextView drn_dt;
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.drown_popup);

        image = findViewById(R.id.drowning_photo);
        drn_dt = findViewById(R.id.drowning_detect);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                finish();
            }
        });

        String url = "http://www.com";

        PopupActivity.NetworkTask networkTask = new PopupActivity.NetworkTask(url, null);
        networkTask.execute();
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

    public class NetworkTask extends AsyncTask<Void, Void, String> {
        private String url;
        private ContentValues values;

        public NetworkTask(String url, ContentValues values){
            this.url = url;
            this.values = values;
        }
        @Override
        protected String doInBackground(Void... params){
            String result; // 요청 결과 저장 변수
            RequestHttpConnection requestHttpURLConnection = new RequestHttpConnection();
            // 해당 URL로부터 결과물 받기
            result = requestHttpURLConnection.request(url, values);

            return result;
        }
        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);

            // doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s 출력
            drn_dt.setText(((MainActivity)MainActivity.context_main).selected_area+"구역 익수자 발견!");
        }
    }
}
