package helloworld.example.administrator.wwduitangdemo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import helloworld.example.administrator.wwduitangdemo.R;
import helloworld.example.administrator.wwduitangdemo.domain.ItemBean;

/**
 * Created by Administrator on 2016/6/6.
 */
public class DynamicListAdapter extends RecyclerView.Adapter<DynamicListAdapter.NormalViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<ItemBean> mData;
    private static final String TAG = "DynamicListAdapter";
    private float itemWidth=0;
    public DynamicListAdapter(Context context, List<ItemBean> data) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mData = data;
    }

    @Override
    public NormalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = mInflater.inflate(R.layout.recycler_item, parent, false);
        NormalViewHolder holder = new NormalViewHolder(rootView);
        return holder;
    }

    @Override
    public void onBindViewHolder(NormalViewHolder holder, int position) {
        ItemBean itemBean = mData.get(position);
        if(itemWidth==0){
            holder.itemView.measure(0,0);
            itemWidth=holder.itemView.getMeasuredWidth();
        }
        Picasso.with(mContext).load(itemBean.imageRes).transform(new CropSquareTransformation(itemWidth)).noFade().into(holder.mImage);
        holder.mIcon.setImageResource(itemBean.userIcon);
        holder.mTitle.setText(itemBean.title);
        holder.mStarNum.setText(itemBean.starNum);
        holder.mName.setText(itemBean.userName);
        holder.mDesc.setText(itemBean.description);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class NormalViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImage;
        public CircleImageView mIcon;
        public TextView mTitle;
        public TextView mStarNum;
        public TextView mName;
        public TextView mDesc;

        public NormalViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.iv_pic);
            mIcon = (CircleImageView) itemView.findViewById(R.id.iv_icon);
            mTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mStarNum = (TextView) itemView.findViewById(R.id.tv_starNum);
            mName = (TextView) itemView.findViewById(R.id.tv_name);
            mDesc = (TextView) itemView.findViewById(R.id.tv_desc);
        }
    }

    /**
     * 实现图片的按比例缩放
     */
    private class CropSquareTransformation implements Transformation{
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
