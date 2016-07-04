package com.namanuma;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.namanuma.model.Item;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private ListView listView;
    
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
        listView = (ListView)findViewById(R.id.listview);

        ListAdapter adapter = new Adapter(this, getItems());

        listView.setAdapter(adapter);
    }

    private class Adapter extends ArrayAdapter<Item> {
        public Adapter(Context context, List<Item> items) {
            super(context, 0, items);
        }
    }

    private List<Item> getItems() {
        List<Item> list = new ArrayList<>();
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

}
