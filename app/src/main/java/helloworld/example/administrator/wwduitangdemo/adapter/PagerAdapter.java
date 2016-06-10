package helloworld.example.administrator.wwduitangdemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import helloworld.example.administrator.wwduitangdemo.R;

/**
 * Created by Administrator on 2016/6/5.
 */
public class PagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentsList;
    private String[] tabNames ;
    public PagerAdapter(FragmentManager fm,List<Fragment> fragmentsList,Context context) {
        super(fm);
        mFragmentsList=fragmentsList;
        tabNames= context.getResources().getStringArray(R.array.TabName);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentsList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabNames[position];
    }
}
