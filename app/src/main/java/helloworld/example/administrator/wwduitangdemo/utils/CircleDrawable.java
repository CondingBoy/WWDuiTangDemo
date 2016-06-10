package helloworld.example.administrator.wwduitangdemo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2016/6/5.
 */
public class CircleDrawable extends Drawable {

    private final Bitmap mBitmap;
    private final Paint mPaint;
    private Rect mRect;
    private final int mWidth;

    public CircleDrawable(Bitmap bitmap){
        mBitmap = bitmap;
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setShader(shader);
        mWidth = Math.min(bitmap.getHeight(),bitmap.getWidth());
    }

    @Override
    public void setBounds(Rect bounds) {
        super.setBounds(bounds);
        mRect = bounds;
    }

    @Override
    public void draw(Canvas canvas) {

        canvas.drawCircle(mWidth/2,mWidth/2,mWidth/2,mPaint);
    }

    @Override
    public int getIntrinsicWidth() {
        return mBitmap.getWidth();
    }

    @Override
    public int getIntrinsicHeight() {
        return mBitmap.getHeight();
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
