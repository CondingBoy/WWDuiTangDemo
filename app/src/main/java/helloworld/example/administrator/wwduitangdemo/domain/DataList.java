package helloworld.example.administrator.wwduitangdemo.domain;

import android.content.ClipData;

import java.util.ArrayList;
import java.util.List;

import helloworld.example.administrator.wwduitangdemo.R;

/**
 * Created by Administrator on 2016/6/6.
 */
public class DataList {
    public static List<ItemBean> getDataList(){
        List<ItemBean> dataList = new ArrayList<ItemBean>();
        ItemBean item1 = new ItemBean(R.mipmap.pic9,"机制的立夏在学习蹭WiFi","154","千年老妖","收集到 插画那么开心",R.mipmap.thumb4);
        ItemBean item2 = new ItemBean(R.mipmap.pic8,"英伦风","145","我不是Candy","收集到 吃吃吃",R.mipmap.thumb3);
        ItemBean item3 = new ItemBean(R.mipmap.pic7,"创意生活","333","乖兽","收集到 备忘录备忘录",R.mipmap.thumb2);
        ItemBean item4 = new ItemBean(R.mipmap.pic6,"简化笔分享","184","千离","收集到 百味美食",R.mipmap.thumb1);
        ItemBean item5 = new ItemBean(R.mipmap.pic5,"#壁纸#","289","水若印心","收集到 布纸喜欢",R.mipmap.thumb0);
        ItemBean item6 = new ItemBean(R.mipmap.pic4,"微型休憩空间","169","红袖","收集到 虫不知",R.mipmap.thumb4);
        ItemBean item7 = new ItemBean(R.mipmap.pic3,"不一样的剪纸","315","荒年信徒","收集到 文字控",R.mipmap.thumb3);
        ItemBean item8 = new ItemBean(R.mipmap.pic2,"废物利用","353","年华逝水","收集到 大白",R.mipmap.thumb2);
        ItemBean item9 = new ItemBean(R.mipmap.pic1,"龙族——我们都是小怪兽，终有一天会被正义的奥特曼杀死","16","来自原始森林的某某某","收集到 龙族",R.mipmap.thumb1);
        ItemBean item10 = new ItemBean(R.mipmap.pic0,"萤火之森","210","默念那曾时","收集到 超级粘土",R.mipmap.thumb0);
        dataList.add(item1);
        dataList.add(item2);
        dataList.add(item3);
        dataList.add(item4);
        dataList.add(item5);
        dataList.add(item6);
        dataList.add(item7);
        dataList.add(item8);
        dataList.add(item9);
        dataList.add(item10);
        return dataList;
    }
    public static List<PagerItemBean> getPagerItemData(){
        List<PagerItemBean> dataList = new ArrayList<PagerItemBean>();
        PagerItemBean item = new PagerItemBean(R.mipmap.top1,"6月7日 周二","我所经历的生活");
        PagerItemBean item2 = new PagerItemBean(R.mipmap.top2,"6月7日 周二","橡皮擦初心");
        PagerItemBean item3= new PagerItemBean(R.mipmap.top3,"6月7日 周二","一只喵的幸福生活");
        PagerItemBean item4= new PagerItemBean(R.mipmap.top4,"6月7日 周二","手绘电影场景");
        dataList.add(item);
        dataList.add(item2);
        dataList.add(item3);
        dataList.add(item4);
        return dataList;
    }
}
