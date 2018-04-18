package com.example.cksharma.myfilescanner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FileDataFragment extends Fragment {


    private List<FileDataItem> listData;
    private FileDataAdapter fileDataAdapter;
    private ListView listView;


    public FileDataFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_file_data, container, false);

        listData = new ArrayList<>();
        listView = (ListView)v.findViewById(R.id.fileDataList);
        fileDataAdapter = new FileDataAdapter(getContext(),R.layout.file_data_item,listData);
        listView.setAdapter(fileDataAdapter);

        return v;
    }

    public void updateData(Update update){
        fileDataAdapter.clear();
        for(int i = 0;i<update.biggestTenFileNames.length;i++){
            FileDataItem fileDataItem = new FileDataItem();
            fileDataItem.name = update.biggestTenFileNames[i];
            fileDataItem.size = Long.toString(update.biggestTenFileSizes[i]);
            fileDataAdapter.add(fileDataItem);
        }
        fileDataAdapter.notifyDataSetChanged();
    }

    public static class FileDataItem{
        public String name ;
        public String size ;
    }

}
