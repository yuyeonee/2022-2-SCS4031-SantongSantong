package com.example.lifeguard_rescue_app;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SAActivity extends AppCompatActivity {
    private String TAG = SAActivity.class.getSimpleName();

    private ListView a_list = null;
    private ListViewAdapter adapter = null;

    String selected_area;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area_setting);

        a_list = (ListView) findViewById(R.id.sa_view);
        adapter.addItem(new AreaItem("A"));
        adapter.addItem(new AreaItem("B"));

        a_list.setAdapter(adapter);
    }

    public class ListViewAdapter extends BaseAdapter {
        ArrayList<AreaItem> items = new ArrayList<AreaItem>();

        @Override
        public int getCount() {
            return items.size();
        }
        public void addItem(AreaItem item) {
            items.add(item);
        }
        @Override
        public Object getItem(int position) {
            return items.get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            final AreaItem areaItem = items.get(position);

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.area_list, viewGroup, false);

            } else {
                View view = new View(context);
                view = (View) convertView;
            }

            TextView area_name = (TextView) convertView.findViewById(R.id.area_name);

            area_name.setText(areaItem.getName());
            Log.d(TAG, "getView() - [ " + position + " ] " + areaItem.getName());

            //각 아이템 선택 event
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selected_area = areaItem.getName();
                }
            });

            return convertView;  //뷰 객체 반환
        }
    }
}


