package com.kip.tichi.pisddetector;


import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Model> implements View.OnClickListener{

    private ArrayList<Model> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;

    }

    public CustomAdapter(ArrayList<Model> data, Context context) {
        super(context, R.layout.custom_layout, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Model dataModel=(Model)object;

        switch (v.getId())
        {
            case R.id.question:
                Snackbar.make(v, "Release date ", Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Model dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.custom_layout, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.question);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.txtName.setText(dataModel.getName());
        // Return the completed view to render on screen
        return result;
    }
}
