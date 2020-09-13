package com.example.daktarlagbe;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.daktarlagbe.adapter.SpinnerAdapter;
import com.example.daktarlagbe.model.LocationSpinnerModel;
import com.example.daktarlagbe.model.SpinnerModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    //spinner
    private ArrayList<SpinnerModel>spinnerModelArrayList;
    private SpinnerAdapter spinnerAdapter;
    TextView fieldName;

    //locationspinner
   /* private ArrayList<LocationSpinnerModel>locationSpinnerModelArrayList;
    private LocationSpinnerAdapter locationSpinnerAdapter;
    DropDownView locationNameDropDown;*/
   //bottomNav
    private ChipNavigationBar bottom_nav;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        bottom_nav = findViewById(R.id.bottom_nav);
        //spinner
        fieldName = findViewById(R.id.fieldName);

        spinnerModelArrayList = new ArrayList<>();
        spinnerModelArrayList.add(new SpinnerModel("All", R.drawable.circleimage1));
        spinnerModelArrayList.add(new SpinnerModel("Doctors", R.drawable.circleimage2));
        spinnerModelArrayList.add(new SpinnerModel("Clinics", R.drawable.circleimage3));
        spinnerModelArrayList.add(new SpinnerModel("Hospitals", R.drawable.circleimage4));

        final Spinner spinner = findViewById(R.id.all_search_spinner);
        spinnerAdapter = new SpinnerAdapter(this, spinnerModelArrayList);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                view.findViewById(R.id.fieldName).setVisibility(View.GONE);

                 SpinnerModel clickedItem = (SpinnerModel)adapterView.getItemAtPosition(i);
                if(clickedItem == (SpinnerModel)adapterView.getItemAtPosition(0)){
                    spinner.setBackgroundResource(R.drawable.all_back);
                }
                else if(clickedItem == (SpinnerModel)adapterView.getItemAtPosition(1)){
                     spinner.setBackgroundResource(R.drawable.doctor_background);
                 }
                else if(clickedItem == (SpinnerModel)adapterView.getItemAtPosition(2)){
                    spinner.setBackgroundResource(R.drawable.clinic_background);
                }
                else {
                    spinner.setBackgroundResource(R.drawable.hospital_background);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //spinner end

        //location name spinner
     /*   locationNameDropDown = findViewById(R.id.locationNameDropDOwn);

     *//*   locationSpinnerModelArrayList = new ArrayList<>();
        locationSpinnerModelArrayList.add(new LocationSpinnerModel("Gulshan"));
        locationSpinnerModelArrayList.add(new LocationSpinnerModel("Banani"));

        locationSpinnerAdapter = new LocationSpinnerAdapter(this,locationSpinnerModelArrayList);
        locationNameDropDown.setDropDownListItem(locationSpinnerAdapter);*//*
        locationNameDropDown.setDropDownListItem(generateFilterList());
        locationNameDropDown.setOnSelectionListener(new OnDropDownSelectionListener() {
            @Override
            public void onItemSelected(DropDownView dropDownView, int position) {

            }
        });*/
        //location  name spinner end

        //Bottom Navigation

        bottom_nav.setItemSelected(R.id.home, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MapsActivity()).commit();
        bottom_nav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i){
                    case R.id.menu:
                        fragment = new MenuFragment();
                        break;
                    case R.id.home:
                        


                    case R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                }
                if(fragment != null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment). commit();
                }
            }
        });
    }

  /*  private List<String> generateFilterList() {
        List<String> list = new ArrayList<>();
        list.add("All");
        list.add("odd");
        list.add("even");
        return list;
    }*/


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}