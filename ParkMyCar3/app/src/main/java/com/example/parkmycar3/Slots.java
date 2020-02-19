package com.example.parkmycar3;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Slots extends AppCompatActivity
{
    public Button slot1confirmation;
    public Button slot2confirmation;
    public Button slot3confirmation;
    public Button slot4confirmation;

    private LocationManager locationManager;
    private LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slots);

        slot1confirmation = (Button) findViewById(R.id.tvSlot1);
        slot2confirmation = (Button) findViewById(R.id.tvSlot2);
        slot3confirmation = (Button) findViewById(R.id.tvSlot3);
        slot4confirmation = (Button) findViewById(R.id.tvSlot4);

        locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener()
        {
            @Override
            public void onLocationChanged(Location location)
            {
                Log.d("Location: ", location.toString());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras)
            {

            }

            @Override
            public void onProviderEnabled(String provider)
            {

            }

            @Override
            public void onProviderDisabled(String provider)
            {

            }
        };


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);

        }
        else
        {

        }

        //  slot1confirmation.setEnabled(false);
        slot1confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Slots.this, Slot1Confirmation.class);
                startActivity(intent);
                slot1confirmation.setEnabled(false);
            }

        });
        slot2confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Slots.this, Slot2Confirmation.class);
                startActivity(intent);
                slot2confirmation.setEnabled(false);
            }

        });
        slot3confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Slots.this, Slot3Confirmation.class);
                startActivity(intent);
                slot3confirmation.setEnabled(false);
            }

        });
        slot4confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Slots.this, Slot4Confirmation.class);
                startActivity(intent);
                slot4confirmation.setEnabled(false);
            }

        });
    }

    @Override
    public void onRequestPermissionsResult (int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
            {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

            }
        }
    }
}

