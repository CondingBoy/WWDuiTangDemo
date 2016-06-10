package helloworld.example.administrator.wwduitangdemo.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import helloworld.example.administrator.wwduitangdemo.R;
import helloworld.example.administrator.wwduitangdemo.adapter.DynamicListAdapter;
import helloworld.example.administrator.wwduitangdemo.domain.DataList;
import helloworld.example.administrator.wwduitangdemo.domain.ItemBean;

/**
 * Created by Administrator on 2016/6/5.
 */
public class DynamicFragment extends Fragment {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private List<ItemBean> mData;
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            refreshLayout.setRefreshing(false);
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = DataList.getDataList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dynamic,container,false);
        refreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swiprefresh);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               mHandler.sendEmptyMessageDelayed(0,3000);
            }
        });
        DynamicListAdapter adapter = new DynamicListAdapter(getActivity(),mData);
        recyclerView.setAdapter(adapter);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        return rootView;
    }
}
