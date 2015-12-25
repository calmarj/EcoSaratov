package org.calmarj.ecosaratov;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

import org.calmarj.ecosaratov.model.Place;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Place.class);
        Parse.initialize(this);


    }
}
