package bwie.com.mvpframe.view.adapter;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/10/25
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    private ArrayList<ImageView> list;
    Context context;

    public BannerAdapter(Context applicationContext, ArrayList<ImageView> guideList) {
        this.context = applicationContext;
        this.list = guideList;
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // 1.获取imageview
        ImageView iv = list.get(position);
        // 2.把imageview添加到viewpager
        container.addView(iv);
        // 3.返回imageview
        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}

