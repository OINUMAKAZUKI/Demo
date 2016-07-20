package com.namanuma.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.namanuma.R;
import com.namanuma.model.Item;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private ListView mListView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initView() {
        mListView = (ListView) findViewById(R.id.listview);

        ListAdapter adapter = new Adapter(this, getItems());

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (getItems().get(position).getActivityType()) {
                    case 0:
                        intent = new Intent(MainActivity.this, MaterialThemeActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, MaterialLightThemeActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, MaterialDarkThemeActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });

        mListView.setAdapter(adapter);
    }

    private class Adapter extends ArrayAdapter<Item> {
        public Adapter(Context context, List<Item> items) {
            super(context, 0, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            }

            TextView textView = (TextView) convertView.findViewById(R.id.textview);
            textView.setText(getItem(position).getName());

            return convertView;
        }
    }

    private List<Item> getItems() {
        List<Item> list = new ArrayList<>();
        list.add(item(getResources().getString(R.string.material_theme), 0));
        list.add(item(getResources().getString(R.string.material_light_theme), 1));
        list.add(item(getResources().getString(R.string.material_dark_theme), 2));
        list.add(item("TextView"));
        list.add(item("Button"));
        list.add(item("ImageButton"));
        list.add(item("ListView"));
        list.add(item("CardView"));
        list.add(item("RecycleView"));
        list.add(item("WebView"));
        return list;
    }

    private Item item(String s) {
        return new Item(s);
    }

    private Item item(String s, int i) {
        return new Item(s, i);
    }

}
