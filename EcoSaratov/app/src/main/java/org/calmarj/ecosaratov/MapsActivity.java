package org.calmarj.ecosaratov;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import org.calmarj.ecosaratov.model.Place;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public static final String TAG = MapsActivity.class.getName();

    public static final String PLACE_TYPE_TAG = "PLACE_TYPE";
    public static final int BEAUTIFUL_PLACE_TYPE = 0;
    public static final int PROBLEM_PLACE_TYPE = 1;

    private static final LatLng SARATOV_LOCATION = new LatLng(51.532958, 46.021120);
    private static final LatLngBounds SARATOV_REGION = new LatLngBounds(new LatLng(50.827394, 42.905798), new LatLng(52.639620, 50.625272));

    private int mPlaceType;

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mPlaceType = getIntent().getIntExtra(PLACE_TYPE_TAG, BEAUTIFUL_PLACE_TYPE);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(SARATOV_REGION, 0));

        getMarkers();
    }

    private void getMarkers() {
        ParseQuery<Place> mapQuery = Place.getQuery();
        mapQuery.whereEqualTo(Place.IS_PROBLEM_KEY, mPlaceType == PROBLEM_PLACE_TYPE);

        mapQuery.findInBackground(new FindCallback<Place>() {
                                      @Override
                                      public void done(List<Place> objects, ParseException e) {
                                          for (Place place : objects) {
                                              MarkerOptions markerOptions = new MarkerOptions().position(new LatLng(place.getLocation().getLatitude(), place.getLocation().getLongitude())).title(place.getTitle());
                                              if (place.getStatus() != null && place.getStatus().equals("Частично решенная")) {
                                                  markerOptions = markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                                              }
                                              mMap.addMarker(markerOptions);
                                          }
                                      }
                                  }
        );
    }


}
