package org.calmarj.ecosaratov.model;

import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@ParseClassName("Place")
public class Place extends ParseObject {

    public final static String LOCATION_KEY = "location";
    public final static String TITLE_KEY = "title";
    public final static String DESCRIPTION_KEY = "description";
    public final static String STATUS_KEY = "status";
    public final static String IS_PROBLEM_KEY = "isProblem";


    public ParseGeoPoint getLocation() {
        return getParseGeoPoint(LOCATION_KEY);
    }

    public void setLocation(ParseGeoPoint value) {
        put(LOCATION_KEY, value);
    }

    public String getTitle() {
        return getString(TITLE_KEY);
    }

    public void setTitle(String value) {
        put(TITLE_KEY, value);
    }

    public String getDescription() {
        return getString(DESCRIPTION_KEY);
    }

    public void setDescription(String value) {
        put(DESCRIPTION_KEY, value);
    }

    public String getStatus() {
        return getString(STATUS_KEY);
    }

    public void setStatus(String value) {
        put(STATUS_KEY, value);
    }

    public boolean getIsProblem() {
        return getBoolean(IS_PROBLEM_KEY);
    }

    public void setIsProblem(Boolean value) {
        put(IS_PROBLEM_KEY, value);
    }

    public static ParseQuery<Place> getQuery() {
        return ParseQuery.getQuery(Place.class);
    }
}