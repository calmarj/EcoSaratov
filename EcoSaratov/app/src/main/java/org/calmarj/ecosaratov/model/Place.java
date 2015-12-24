package org.calmarj.ecosaratov.model;

import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@ParseClassName("Place")
public class Place extends ParseObject {

    public ParseGeoPoint getLocation() {
        return getParseGeoPoint("location");
    }

    public void setLocation(ParseGeoPoint value) {
        put("location", value);
    }

    public String getDescription() {
        return getString("description");
    }

    public void setDescription(String value) {
        put("description", value);
    }

    public String getStatus() {
        return getString("status");
    }

    public void setStatus(String value) {
        put("status", value);
    }

    public static ParseQuery<Place> getQuery() {
        return ParseQuery.getQuery(Place.class);
    }
}