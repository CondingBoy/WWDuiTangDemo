package helloworld.example.administrator.wwduitangdemo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import helloworld.example.administrator.wwduitangdemo.R;

/**
 * Created by Administrator on 2016/6/5.
 */
public class DiscoveryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_discovery,container,false);
        return rootView;
    }
}
