package com.example.duan1_android.Maps;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import com.example.duan1_android.R;
import com.example.duan1_android.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jetbrains.annotations.NotNull;

import java.util.Vector;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    MarkerOptions maker;
    Vector<MarkerOptions> markerOptions;
    LatLng centerLocation;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        centerLocation = new LatLng(10.8037045,106.72437);
        markerOptions = new Vector<>();
        markerOptions.add(new MarkerOptions().title("The Coffe House -Trần Não")
                .position(new LatLng(10.7879312,106.7212828))
                .snippet("Mở cửa: 07:00 - 21:00"));

        markerOptions.add(new MarkerOptions().title("The Coffe House D1")
                .position(new LatLng(10.8019253,106.7102155))
                .snippet("Mở cửa: 07:00 - 21:00"));

        markerOptions.add(new MarkerOptions().title("The Coffe House - Cantavil")
                .position(new LatLng(10.8015501,106.7383103))
                .snippet("Mở cửa: 07:00 - 21:00"));


        mapFragment.getMapAsync(this);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        for (MarkerOptions mark: markerOptions){
            mMap.addMarker(mark);
        }
        enableMyLocation();


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerLocation,13.0f));
        
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        } else {

            String permis[] = {"android.permission.ACCESS_FINE_LOCATION"};
            ActivityCompat.requestPermissions(this, permis,200);
        }
    }



}