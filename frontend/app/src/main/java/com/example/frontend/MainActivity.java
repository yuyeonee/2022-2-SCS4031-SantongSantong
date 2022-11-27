package com.example.frontend;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class MainActivity extends AppCompatActivity {
    Button btn_setarea, btn_rqst,btn_test;
    AlertDialog.Builder builder;
    String[] area;
    public static Context context_main;
    public String selected_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context_main = this;

        btn_test = findViewById(R.id.testbtn);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent test = new Intent(MainActivity.this, PopupActivity.class);
                startActivity(test);
            }
        });

        btn_rqst = findViewById(R.id.detect_request_button);
        btn_rqst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ClientThread thread = new ClientThread();
                thread.start();
                TextView detecting_text = (TextView) findViewById(R.id.detect_text);
                Log.d(this.getClass().getName(), (String)detecting_text.getText());
                detecting_text.setText("탐지 중..");
            }
        });
        btn_setarea = findViewById(R.id.set_area_button);
        btn_setarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }
    class ClientThread extends Thread{
        @Override
        public void run(){
            String host = "localhost";
            int port = 8000;
            try {
                Socket socket = new Socket(host, port);

                ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
                outstream.writeObject("탐지 요청");
                outstream.flush();
                Log.d("ClientStream", "Sent to server.");

                ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());
                Object input = instream.readObject();

                Intent intent = new Intent(MainActivity.this, PopupActivity.class);
                startActivity(intent);
                // Log.d("ClientThread", "Received data: " + input);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void showDialog(){
        area = getResources().getStringArray(R.array.area);
        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("근무 지역을 선택하세요");
        builder.setItems(area, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getApplicationContext(), "요원님의 구역이 "+area[which]+"로 설정되었습니다.", Toast.LENGTH_SHORT).show();
            TextView areaView = (TextView) findViewById(R.id.slc_area);
            Log.d(this.getClass().getName(), (String)areaView.getText());
            selected_area = area[which];
            areaView.setText("현재 설정된 근무지 : "+selected_area);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
