package helloworld.example.administrator.wwduitangdemo.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 解决与viewpager的滑动冲突
 * Created by Administrator on 2016/6/8.
 */
public class CustomRefresh extends SwipeRefreshLayout {
    private int startX;
    private int startY;
    public CustomRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX= (int) ev.getX();
                startY= (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int detalX = (int) Math.abs(ev.getX()-startX);
                int detalY = (int) Math.abs(ev.getY()-startY);
                //判断是横向滑动还是纵向滑动
                if(detalX>detalY){
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
