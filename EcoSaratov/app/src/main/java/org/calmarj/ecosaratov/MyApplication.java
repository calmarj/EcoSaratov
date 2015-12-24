package org.calmarj.ecosaratov;

import com.activeandroid.ActiveAndroid;

/**
 * Created by calmarj on 24.12.15.
 */
public class MyApplication extends com.activeandroid.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
