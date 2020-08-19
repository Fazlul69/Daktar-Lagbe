package com.example.daktarlagbe.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.daktarlagbe.R;
import com.example.daktarlagbe.model.SpinnerModel;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<SpinnerModel> {

    public SpinnerAdapter(Context context, ArrayList<SpinnerModel>spinnerModelArrayList){
        super(context,0, spinnerModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    private View initView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_item,parent,false);
        }

        ImageView fieldImage = convertView.findViewById(R.id.fieldImage);
        TextView fieldName = convertView.findViewById(R.id.fieldName);

        SpinnerModel spinnerModel = getItem(position);

        if(spinnerModel != null){
            fieldImage.setImageResource(spinnerModel.getFieldImage());
            fieldName.setText(spinnerModel.getFieldName());
        }
        return convertView;
    }
}
