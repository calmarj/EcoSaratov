package org.calmarj.ecosaratov;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import org.calmarj.ecosaratov.model.Place;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public static final String TAG = MapsActivity.class.getName();

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        getMarkers();
    }

    private void getMarkers() {
        ParseQuery<Place> mapQuery = Place.getQuery();

        mapQuery.findInBackground(new FindCallback<Place>() {
            @Override
            public void done(List<Place> objects, ParseException e) {
                for (Place place : objects) {
                    MarkerOptions markerOptions = new MarkerOptions().position(new LatLng(place.getLocation().getLatitude(), place.getLocation().getLongitude()));
                    if (place.getStatus().equals("Частично решенная")) {
                        markerOptions = markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                    }
                    mMap.addMarker(markerOptions);

                }
            }
        });
    }


}
