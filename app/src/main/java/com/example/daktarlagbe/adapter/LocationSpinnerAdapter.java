package com.example.daktarlagbe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.daktarlagbe.R;
import com.example.daktarlagbe.model.LocationSpinnerModel;

import java.util.ArrayList;

public class LocationSpinnerAdapter extends ArrayAdapter<LocationSpinnerModel> {

    public LocationSpinnerAdapter(Context context, ArrayList<LocationSpinnerModel>locationSpinnerModelArrayList){
        super(context,0,locationSpinnerModelArrayList);
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
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.location_spinner_item,parent,false);
        }

        TextView locationName = convertView.findViewById(R.id.locationName);

        LocationSpinnerModel locationSpinnerModel = getItem(position);

        if(locationSpinnerModel != null){
            locationName.setText(locationSpinnerModel.getLocationName());
        }
        return convertView;
    }
}
