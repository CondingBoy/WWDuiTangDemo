package helloworld.example.administrator.wwduitangdemo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

import javax.crypto.spec.PSource;

import de.hdodenhof.circleimageview.CircleImageView;
import helloworld.example.administrator.wwduitangdemo.R;
import helloworld.example.administrator.wwduitangdemo.domain.ItemBean;

/**
 * Created by Administrator on 2016/6/7.
 */
public class GridViewAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<ItemBean> mData;
    private final LayoutInflater mInflater;
    private float itemWidth;
    public GridViewAdapter(Context context, List<ItemBean> data){
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public ItemBean getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemBean itemBean = getItem(position);
        ViewHolder viewHolder = null;
        if(convertView==null){
            convertView=mInflater.inflate(R.layout.recycler_item,null);
            viewHolder=new ViewHolder();
            viewHolder.mImage= (ImageView) convertView.findViewById(R.id.iv_pic);
            viewHolder.mIcon = (CircleImageView) convertView.findViewById(R.id.iv_icon);
            viewHolder.mTitle = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.mStarNum = (TextView) convertView.findViewById(R.id.tv_starNum);
            viewHolder.mName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.mDesc = (TextView) convertView.findViewById(R.id.tv_desc);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        if(itemWidth==0){
            convertView.measure(0,0);
            itemWidth=convertView.getMeasuredWidth();
        }
        Picasso.with(mContext).load(itemBean.imageRes).transform(new CropSquareTransformation(itemWidth)).noFade().into(viewHolder.mImage);
        viewHolder.mIcon.setImageResource(itemBean.userIcon);
        viewHolder.mTitle.setText(itemBean.title);
        viewHolder.mStarNum.setText(itemBean.starNum);
        viewHolder.mName.setText(itemBean.userName);
        viewHolder.mDesc.setText(itemBean.description);
        return convertView;
    }
    private class ViewHolder{
        public ImageView mImage;
        public CircleImageView mIcon;
        public TextView mTitle;
        public TextView mStarNum;
        public TextView mName;
        public TextView mDesc;
    }
    /**
     * 实现图片的按比例缩放
     */
    private class CropSquareTransformation implements Transformation {
        private float mMaxWidth;
        public CropSquareTransformation(float maxWidth){
            mMaxWidth=maxWidth;
        }
        @Override
        public Bitmap transform(Bitmap source) {
            int tagetWidth =0;
            int tagetHeight =0;
            if(source.getWidth()==0||source.getHeight()==0){
                return source;
            }
            //根据传入的宽度，重新计算图片的宽高
            int imageWidth = source.getWidth();
            int imageHeight = source.getHeight();
            tagetWidth= (int) mMaxWidth;
            float mRatio = mMaxWidth/source.getWidth();
            tagetHeight= (int) (mRatio*source.getHeight());
            if(tagetWidth!=0&&tagetHeight!=0){
                //根据宽高将图片缩放,若与原图片宽高一样，不会返回新图片
                Bitmap result = Bitmap.createScaledBitmap(source,tagetWidth,tagetHeight,false);
                if (result!=source){
                    source.recycle();
                }
                return result;
            }else {
                return source;
            }

        }

        @Override
        public String key() {
            return "desiredWidth"+"desiredHeight";
        }
    }
}
