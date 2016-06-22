package com.codekul.reallyfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.*;
/**
 * A simple {@link Fragment} subclass.
 */
public class MyListFragment extends Fragment {


    public MyListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view =
                inflater.inflate(R.layout.fragment_my_list, container, false);

        ArrayList<String> dataSetCities=new ArrayList<>();
        dataSetCities.add("Popeye");
        dataSetCities.add("Micky Mouse");
        dataSetCities.add("Road Runner");
        dataSetCities.add("Tom and jerry");
        dataSetCities.add("Swat cats");
        dataSetCities.add("filstones");
        dataSetCities.add("goofy");
        dataSetCities.add("silvester and tweety");

        final ListView listCities =
                (ListView) view.findViewById(R.id.listCities);
        listCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView textView = (TextView) view;

                MainActivity act = (MainActivity)
                        getActivity();

                act.runFragmentTransaction(R.id.frameContainer,
                        ImageFragment
                                .getInstance(textView
                                        .getText()
                                        .toString()));
            }
        });

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1,
                        dataSetCities);


        listCities.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }

}
