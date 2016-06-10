package helloworld.example.administrator.wwduitangdemo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ScrollView;

import helloworld.example.administrator.wwduitangdemo.view.CustomScrollView;

/**
 * Created by Administrator on 2016/6/6.
 */
public class PersonActivity extends AppCompatActivity {

    private Drawable drawable;
    private CustomScrollView scrollView;
    private static final String TAG = "PersonActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //让actionbar浮动显示
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_person);
        final ActionBar mActionBar = getSupportActionBar();
        mActionBar.setElevation(0);
        mActionBar.setTitle("用户");
        mActionBar.setDisplayHomeAsUpEnabled(true);
        drawable = new ColorDrawable(getResources().getColor(android.R.color.background_dark));
        drawable.setAlpha(0);
        mActionBar.setBackgroundDrawable(drawable);
        scrollView = (CustomScrollView) findViewById(R.id.scroller);
        scrollView.setOnScrollChangedObserver(new CustomScrollView.OnScrollChangedObserver() {
            @Override
            public void onScrollchange(int l, int t, int oldl, int oldt) {
              int alpha = 0;
                if(t>255){
                    alpha=255;
                }else {
                    alpha=t;
                }
                drawable.setAlpha(alpha);


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.person_activity,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
