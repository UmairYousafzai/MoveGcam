package moveitec.com.Utils;

import android.graphics.Bitmap;
import android.view.View;

import java.util.Date;

import moveitec.com.R;

public class ScreenShot {

    private static ScreenShot screenShot= null;

    private ScreenShot()
    {

    }
    public static ScreenShot getInstance()
    {
        if (screenShot==null)
        {
            screenShot = new ScreenShot();
        }
        return screenShot;
    }
    public Bitmap takeScreenshot(View view) {

        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        try {
            // image naming and path  to include sd card  appending name you choose for file

            // create bitmap screen capture

            view.setDrawingCacheEnabled(true);
            return Bitmap.createBitmap(view.getDrawingCache());

        } catch (Throwable e) {
            // Several error may come out with file handling or DOM
            e.printStackTrace();
            return null;
        }
    }


}
