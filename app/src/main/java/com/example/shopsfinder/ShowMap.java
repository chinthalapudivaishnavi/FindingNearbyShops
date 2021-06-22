package com.example.shopsfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class ShowMap extends AppCompatActivity implements OnMapReadyCallback {

    Button showmap_btn;
    boolean flag=false;
    FusedLocationProviderClient mFusedLocationClient;
    int PERMISSION_ID = 44;
    double currentLatitude=0.0;
    double currentLongitude=0.0;
    SupportMapFragment supportMapFragment;
    GoogleMap map;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_map);

      fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        showmap_btn=findViewById(R.id.shownearby_shops_btn_id);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapfragment_id);
        // method to get the location
        getLastLocation();
        showmap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((currentLatitude!=0.0 || currentLongitude!=0.0) && flag==true)
                {
                    String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json" + "?location=" +currentLatitude + "," + currentLongitude+ "&radius=10000" + "&types=" + "store" + "&sensor=true" + "&key=" + getResources().getString(R.string.google_map_key);
                    // String url="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=14.7118034,77.8116331&radius=5000&types=atm&sensor=true&key=AIzaSyDZr9lC4IS9gxn5ucWqK16B-WIIHnHBLVU";
                    System.out.println("the url is----------//            return null;--------------------:  "+url+"   ----------------------------------------");

                    //executing the placetask method to download the json data
                    new PlaceTask().execute(url);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please make sure internet and location services turn on", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private class PlaceTask extends AsyncTask<String,Integer,String> {

        @Override
        protected String doInBackground(String... strings) {
            String data=null;
            try {
                data=downloadUrl(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            new ParcerTask().execute(s);
        }
    }

    private String downloadUrl(String string) throws IOException {
        //initializing url
        URL url=new URL(string);
        //initialiing the connection
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
        connection.connect();
        InputStream stream=connection.getInputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
        StringBuilder builder=new StringBuilder();
        String line="";
        while ((line=reader.readLine())!=null)
        {
            builder.append(line);
        }
        String data=builder.toString();
        reader.close();

        return data;
    }

    private class ParcerTask extends AsyncTask<String,Integer, List<HashMap<String,String>>>{

        @Override
        protected List<HashMap<String, String>> doInBackground(String... strings) {
            //create json parser class
            JsonParser jsonParser=new JsonParser();
            //initialize hash map list
            List<HashMap<String, String>> mapList=null;
            JSONObject object=null;

            try {
                //initialize json object
                object=new JSONObject(strings[0]);
                //parse json object
                mapList=jsonParser.parseResult(object);


            } catch (JSONException e) {
                e.printStackTrace();
            }
            //returning map list
            return mapList;
        }

        @Override
        protected void onPostExecute(List<HashMap<String, String>> hashMaps) {
            //clearing map
            map.clear();

            for (int i=0;i<hashMaps.size();i++)
            {
                //initializing hashmap
                HashMap<String,String> hashMapList=hashMaps.get(i);
                //get lattitude
                double lat= Double.parseDouble(hashMapList.get("lat"));
                //get longitude
                double lng= Double.parseDouble(hashMapList.get("lng"));
                //get name
                String name=hashMapList.get("name");
                //concat latitude and longtude
                LatLng latLng=new LatLng(lat,lng);
                //initializing marker options
                MarkerOptions options=new MarkerOptions();
                //set position
                options.position(latLng);
                //set title
                options.title(name);
                map.addMarker(options);
            }
        }
    }
    @SuppressLint("MissingPermission")
    private void getLastLocation()
    {
        // check if permissions are given
        if (checkPermissions()) {

            // check if location is enabled
            if (isLocationEnabled()) {

                // getting last
                // location from
                // FusedLocationClient
                // object
                supportMapFragment.getMapAsync(this);
                mFusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Location location = task.getResult();
                        if (location == null) {
                            requestNewLocationData();
                        } else {
                            currentLatitude=location.getLatitude();
                            currentLongitude=location.getLongitude();
                            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+location.getLatitude() + "");
                            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+location.getLongitude() + "");
                            if(flag==true)
                            {
                                LatLng latLng=new LatLng(currentLatitude,currentLongitude);
                                MarkerOptions markerOptions=new MarkerOptions().position(latLng).title("Current Location");
                                map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,14));
                                map.addMarker(markerOptions).showInfoWindow();
                            }
                        }
                    }
                });
            } else {
                Toast.makeText(this, "Please turn on" + " your location...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            // if permissions aren't available,
            // request for permissions
            requestPermissions();
        }
    }
    @SuppressLint("MissingPermission")
    private void requestNewLocationData() {

        // Initializing LocationRequest
        // object with appropriate methods
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(5);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        // setting LocationRequest
        // on FusedLocationClient
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
    }
    private LocationCallback mLocationCallback = new LocationCallback() {

        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();
            currentLatitude=mLastLocation.getLatitude();
            currentLongitude=mLastLocation.getLongitude();
            if(flag==true)
            {
                LatLng latLng=new LatLng(currentLatitude,currentLongitude);
                MarkerOptions markerOptions=new MarkerOptions().position(latLng).title("Current Location");
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,19));
                map.addMarker(markerOptions).showInfoWindow();
            }
            System.out.println("Latitude: " + mLastLocation.getLatitude() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Longitude: " + mLastLocation.getLongitude() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@22");
        }
    };

    // method to check for permissions
    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        // If we want background location
        // on Android 10.0 and higher,
        // use:
        // ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED
    }
    // method to request for permissions
    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_ID);
    }

    // method to check
    // if location is enabled
    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }
    // If everything is alright then
    @Override
    public void
    onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            }
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        if (checkPermissions()) {
            getLastLocation();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;

       flag=true;
    }
}