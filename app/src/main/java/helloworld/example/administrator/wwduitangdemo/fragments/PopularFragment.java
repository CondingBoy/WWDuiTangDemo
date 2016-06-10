package helloworld.example.administrator.wwduitangdemo.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.etsy.android.grid.StaggeredGridView;

import java.util.TimerTask;

import helloworld.example.administrator.wwduitangdemo.R;
import helloworld.example.administrator.wwduitangdemo.adapter.GridViewAdapter;
import helloworld.example.administrator.wwduitangdemo.adapter.TopPagerAdapter;
import helloworld.example.administrator.wwduitangdemo.domain.DataList;
import helloworld.example.administrator.wwduitangdemo.view.PagerIndicator;

/**
 * Created by Administrator on 2016/6/5.
 */
public class PopularFragment extends Fragment {

    private StaggeredGridView gridView;
    private GridViewAdapter adapter;
    private SwipeRefreshLayout refreshLayout;
    private static final String TAG = "PopularFragment";
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            refreshLayout.setRefreshing(false);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: " );
        View rootView = inflater.inflate(R.layout.fragment_popular,container,false);
        refreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.refresh);
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               mHandler.sendEmptyMessageDelayed(0,2000);
            }
        });
        gridView = (StaggeredGridView) rootView.findViewById(R.id.gridview);
        adapter = new GridViewAdapter(getActivity(), DataList.getDataList());
        //设置gridview的headerview
        View headView = inflater.inflate(R.layout.gridview_header,null);
        PagerIndicator indicator = (PagerIndicator) headView.findViewById(R.id.indicator);
        ViewPager viewPager = (ViewPager) headView.findViewById(R.id.viewpager_top);
        TopPagerAdapter topPagerAdapter = new TopPagerAdapter(getActivity(),DataList.getPagerItemData());
        viewPager.setAdapter(topPagerAdapter);
        indicator.setViewPager(viewPager);
        gridView.addHeaderView(headView);
        gridView.setAdapter(adapter);
        return rootView;
    }
}
