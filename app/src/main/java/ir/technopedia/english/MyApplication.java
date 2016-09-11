package ir.technopedia.english;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by TheLoneWolf on 9/3/2016.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/iransans.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
