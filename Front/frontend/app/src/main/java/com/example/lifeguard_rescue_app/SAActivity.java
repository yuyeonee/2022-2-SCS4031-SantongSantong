package com.example.lifeguard_rescue_app;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SAActivity extends AppCompatActivity {
    private String TAG = SAActivity.class.getSimpleName();

    private ListView a_list = null;
    private ListViewAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area_setting);

        a_list = (ListView) findViewById(R.id.set_area);
        adapter.addItem(new AreaItem("A"));
        adapter.addItem(new AreaItem("B"));
        adapter.addItem(new AreaItem("C"));

        a_list.setAdapter(adapter);
    }
}

public class ListViewAdapter extends BaseAdapter{
    ArrayList<AreaItem> items = new ArrayList<AreaItem>();

    @Override
    public int getCount(){
        return items.size();
    }
    public void addItem(AreaItem item){
        items.add(item);
    }
    @Override
    public Object getItem(int position){
        return items.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final Context context = viewGroup.getContext();
        final BearItem bearItem = items.get(position);

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_list_item, viewGroup, false);

        } else {
            View view = new View(context);
            view = (View) convertView;
        }

        TextView tv_num = (TextView) convertView.findViewById(R.id.tv_num);
        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
        ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);

        tv_num.setText(bearItem.getNum());
        tv_name.setText(bearItem.getName());
        iv_icon.setImageResource(bearItem.getResId());
        Log.d(TAG, "getView() - [ "+position+" ] "+bearItem.getName());

        //각 아이템 선택 event
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, bearItem.getNum()+" 번 - "+bearItem.getName()+" 입니당! ", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;  //뷰 객체 반환
    }
}

