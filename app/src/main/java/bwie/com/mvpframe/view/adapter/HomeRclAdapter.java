package bwie.com.mvpframe.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.classic.adapter.BaseAdapterHelper;
import com.classic.adapter.CommonRecyclerAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.List;

import bwie.com.mvpframe.R;
import bwie.com.mvpframe.model.bean.HomeBean;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/10/25
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class HomeRclAdapter extends CommonRecyclerAdapter<HomeBean.StoriesBean> {
    public HomeRclAdapter(@NonNull Context context, int layoutResId, List<HomeBean.StoriesBean> data) {
        super(context, layoutResId, data);
    }

    @Override
    public void onUpdate(BaseAdapterHelper helper, HomeBean.StoriesBean item, int position) {
        helper.setText(R.id.tv_home_rcl_item, item.title);

        final ImageView imageView = helper.getView().findViewById(R.id.img_home_rcl_item);
        ImageLoader.getInstance().loadImage(item.images.get(0), new SimpleImageLoadingListener() {

            @Override
            public void onLoadingComplete(String imageUri, View view,
                                          Bitmap loadedImage) {
                super.onLoadingComplete(imageUri, view, loadedImage);
                imageView.setImageBitmap(loadedImage);
            }

        });
    }
}
