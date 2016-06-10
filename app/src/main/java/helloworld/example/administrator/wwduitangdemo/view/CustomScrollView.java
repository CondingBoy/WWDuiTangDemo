package helloworld.example.administrator.wwduitangdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2016/6/7.
 */
public class CustomScrollView extends ScrollView {
    private OnScrollChangedObserver mObserver;
    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (mObserver != null) {
            mObserver.onScrollchange(l,t,oldl,oldt);
        }
    }
    public void setOnScrollChangedObserver(OnScrollChangedObserver observer){
        mObserver=observer;
    }
    public interface OnScrollChangedObserver{
        void onScrollchange(int l, int t, int oldl, int oldt);
    }
}
