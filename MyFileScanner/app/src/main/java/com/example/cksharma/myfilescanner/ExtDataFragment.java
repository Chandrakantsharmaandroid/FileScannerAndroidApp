package com.example.cksharma.myfilescanner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExtDataFragment extends Fragment {
    private ArrayAdapter<String> extAdapter;
    private ListView listView;
    List<String> data;
    Set<String> dataSet;

    public ExtDataFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ext_data, container, false);

        data=new ArrayList<>();
        listView = (ListView)v.findViewById(R.id.extDataList);
        extAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, data);
        listView.setAdapter(extAdapter);

        return v;
    }

    public void updateData(Update update){
        extAdapter.clear();
        dataSet=new HashSet<>();
        if(update.mostFrequentFiveExtensions!=null && update.mostFrequentFiveExtensions.length>0) {
            for (int i = 0; i < 5; i++) {
                extAdapter.add((i+1) + " - Most frequent ext is :");
                data.add(update.mostFrequentFiveExtensions[i]);
            }
                extAdapter.notifyDataSetChanged();
        }
    }


}
