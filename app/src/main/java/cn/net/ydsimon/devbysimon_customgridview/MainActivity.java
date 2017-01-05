package cn.net.ydsimon.devbysimon_customgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<HashMap<String, Object>> dataSourceList = new ArrayList<HashMap<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DragGridView mDragGridView = (DragGridView) findViewById(R.id.dragGridView);
        for (int i = 0; i < 4; i++) {
            HashMap<String, Object> itemHashMap = new HashMap<String, Object>();
            itemHashMap.put("item_image", R.mipmap.ic_launcher);
            itemHashMap.put("item_text", "数据" + Integer.toString(i));
            dataSourceList.add(itemHashMap);
        }

        final DragAdapter mDragAdapter = new DragAdapter(this, dataSourceList);

        mDragGridView.setAdapter(mDragAdapter);
        mDragGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item_text = (String) dataSourceList.get(i).get("item_text");
                Toast.makeText(MainActivity.this, item_text, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
