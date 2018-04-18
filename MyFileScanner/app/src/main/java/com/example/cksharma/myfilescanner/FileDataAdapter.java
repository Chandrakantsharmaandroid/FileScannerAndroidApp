package com.example.cksharma.myfilescanner;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class FileDataAdapter extends ArrayAdapter<FileDataFragment.FileDataItem> {

    private Context context;
    private int resourceID;
    private List<FileDataFragment.FileDataItem> data;

    public FileDataAdapter(Context context, int resource,List<FileDataFragment.FileDataItem> data) {
        super(context, resource);
        this.context = context;
        this.resourceID = resource;
        this.data = data;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(resourceID, parent, false);

            holder = new ViewHolder();
            holder.name = (TextView)row.findViewById(R.id.file_name_view);
            holder.size = (TextView)row.findViewById(R.id.file_size_view);

            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)row.getTag();
        }

            FileDataFragment.FileDataItem dataHeld = data.get(position);

                if (dataHeld.name!=null&&dataHeld.name.length() > 15) {
                    holder.name.setText(dataHeld.name.substring(0, 15));
                } else {
                    holder.name.setText(dataHeld.name);
                }


                holder.size.setText(dataHeld.size);

        return row;
    }

    @Override
    public void clear() {
        super.clear();
        data.clear();
        notifyDataSetChanged();
    }

    @Override
    public void add(FileDataFragment.FileDataItem object) {
        super.add(object);
        data.add(object);
        notifyDataSetChanged();
    }

    private static class ViewHolder{
        TextView name;
        TextView size;
    }
}
