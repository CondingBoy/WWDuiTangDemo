package helloworld.example.administrator.wwduitangdemo.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by Administrator on 2016/6/6.
 */
public class BitmapUtils {
    public static Bitmap changeLum(Bitmap bitmap,float lum){
        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(newBitmap);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(lum,lum,lum,1);
        Paint mPaint = new Paint();
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        mCanvas.drawBitmap(bitmap,0,0,mPaint);
        return newBitmap;
    }
}
