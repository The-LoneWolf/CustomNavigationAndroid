package ir.technopedia.english.helper;

import android.content.Context;
import android.support.v7.widget.Toolbar;

/**
 * Created by TheLoneWolf on 9/11/2016.
 */
public class MyUtils {

    public static void CustomizeStatusbar(Context context, Toolbar toolbar) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        toolbar.setMinimumHeight(toolbar.getHeight() + result);
    }
}
