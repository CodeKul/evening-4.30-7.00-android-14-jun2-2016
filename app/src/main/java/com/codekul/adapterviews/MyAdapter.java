package com.codekul.adapterviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aniruddha on 20/6/16.
 */
public class MyAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<MyItem> dataSet;
    private LayoutInflater inflater;

    public MyAdapter(Context context, ArrayList<MyItem> dataSet){
        this.context = context;
        this.dataSet = dataSet;

        inflater = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 15 * position; // your logic
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View myView = null;
        if(position == 0){

            myView = inflater.inflate(R.layout.item_zeroth,
                    parent,
                    false);
        }
        else {

                    myView = inflater.inflate(R.layout.custom_item,
                            parent,
                            false);

            MyItem item = dataSet.get(position);

            ImageView imageIcon = (ImageView) myView
                    .findViewById(R.id.imageIcon);
            imageIcon.setImageResource(item.getImageIcon());

            TextView textCountry = (TextView) myView
                    .findViewById(R.id.textCountry);
            textCountry.setText(item.getNameCountry());
        }

        return myView;
    }
}
