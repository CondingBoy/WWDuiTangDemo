package helloworld.example.administrator.wwduitangdemo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

import helloworld.example.administrator.wwduitangdemo.R;
import helloworld.example.administrator.wwduitangdemo.domain.PagerItemBean;
import helloworld.example.administrator.wwduitangdemo.utils.BitmapUtils;

/**
 * Created by Administrator on 2016/6/7.
 */
public class TopPagerAdapter extends android.support.v4.view.PagerAdapter {

    private final Context mContext;
    private final List<PagerItemBean> mData;
    private final LayoutInflater mInflater;

    public TopPagerAdapter(Context context, List<PagerItemBean> data){
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        PagerItemBean item = mData.get(position);
        View rootView = mInflater.inflate(R.layout.page_item,null);
        ImageView mImage = (ImageView) rootView.findViewById(R.id.iv_pager_top);
        TextView mTime = (TextView) rootView.findViewById(R.id.tv_pager_top_time);
        TextView mTitle = (TextView) rootView.findViewById(R.id.tv_pager_top_title);
        Picasso.with(mContext).load(item.mImageRes).transform(new CropSquareTransformation()).noFade().into(mImage);
        mTime.setText(item.mTime);
        mTitle.setText(item.mTitle);
        container.addView(rootView);
        return rootView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View)object);
    }
    /**
     * 实现图片的按比例缩放
     */
    private class CropSquareTransformation implements Transformation {

        @Override
        public Bitmap transform(Bitmap source) {
            if(source.getWidth()==0||source.getHeight()==0){
                return source;
            }
            Bitmap result =BitmapUtils.changeLum(source,0.5f);
            source.recycle();
            return  result;
        }

        @Override
        public String key() {
            return "desiredWidth"+"desiredHeight";
        }
    }
}
