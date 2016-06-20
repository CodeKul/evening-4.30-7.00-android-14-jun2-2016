package com.codekul.adapterviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        useCustomAdapter();
    }

    private void userArrayAdapter(){

        final ListView listCountries =
                (ListView) findViewById(R.id.listCountreies);

//        final GridView listCountries =
//                (GridView) findViewById(R.id.listCountreies);

        ArrayList<String> dataSet =
                new ArrayList<>();
        dataSet.add("India");
        dataSet.add("china");
        dataSet.add("Japan");
        dataSet.add("Shri Lanka");

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        dataSet);
        listCountries.setAdapter(adapter);
    }

    private void useCustomAdapter(){

        final ListView listCountries =
                (ListView) findViewById(R.id.listCountreies);

//        final GridView listCountries =
//                (GridView) findViewById(R.id.listCountreies);

        ArrayList<MyItem> dataSet =
                new ArrayList<>();

        MyItem item1 = new MyItem();
        item1.setImageIcon(R.mipmap.ic_launcher);
        item1.setNameCountry("India");
        dataSet.add(item1);

        MyItem item2 = new MyItem();
        item2.setImageIcon(R.mipmap.ic_launcher);
        item2.setNameCountry("China");
        dataSet.add(item2);

        MyItem item3 = new MyItem();
        item3.setImageIcon(R.mipmap.ic_launcher);
        item3.setNameCountry("Japan");
        dataSet.add(item3);

        MyItem item4 = new MyItem();
        item4.setImageIcon(R.mipmap.ic_launcher);
        item4.setNameCountry("America");
        dataSet.add(item4);

        MyAdapter adapter = new MyAdapter(this,dataSet);

        listCountries.setAdapter(adapter);
    }

}
