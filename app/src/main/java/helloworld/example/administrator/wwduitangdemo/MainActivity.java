
package helloworld.example.administrator.wwduitangdemo;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import helloworld.example.administrator.wwduitangdemo.adapter.PagerAdapter;
import helloworld.example.administrator.wwduitangdemo.fragments.DiscoveryFragment;
import helloworld.example.administrator.wwduitangdemo.fragments.DynamicFragment;
import helloworld.example.administrator.wwduitangdemo.fragments.MessageFragment;
import helloworld.example.administrator.wwduitangdemo.fragments.PopularFragment;
import helloworld.example.administrator.wwduitangdemo.utils.CircleDrawable;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> mFragmentsList;
    private ViewPager mViewPager;
    private PagerSlidingTabStrip mTabStrip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initActionbar();

    }

    private void initActionbar() {
        android.support.v7.app.ActionBar mActionbar = getSupportActionBar();
        mActionbar.setDisplayHomeAsUpEnabled(true);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.user_default_face);

        mActionbar.setHomeAsUpIndicator(new CircleDrawable(bitmap));
//        mActionbar.setDisplayShowHomeEnabled(true);
//        mActionbar.setIcon(new CircleDrawable(bitmap));
        mActionbar.setTitle(" 用户");
//        mActionbar.setHomeButtonEnabled(true);
        mActionbar.setElevation(0);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabStrip = (PagerSlidingTabStrip) findViewById(R.id.pager_tab);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),mFragmentsList,this);
        mViewPager.setAdapter(adapter);
        mTabStrip.setViewPager(mViewPager);
        Toast.makeText(MainActivity.this, "app", Toast.LENGTH_SHORT).show();

    }

    private void initData() {
        mFragmentsList = new ArrayList<Fragment>();
        PopularFragment popularFragment = new PopularFragment();
        DiscoveryFragment discoveryFragment = new DiscoveryFragment();
        DynamicFragment dynamicFragment = new DynamicFragment();
        MessageFragment messageFragment = new MessageFragment();
        mFragmentsList.add(popularFragment);
        mFragmentsList.add(discoveryFragment);
        mFragmentsList.add(dynamicFragment);
        mFragmentsList.add(messageFragment);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(this,PersonActivity.class));
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
