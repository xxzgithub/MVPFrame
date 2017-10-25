package bwie.com.mvpframe.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayout;
import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayoutDirection;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import bwie.com.mvpframe.BaseFragment.BaseFragment;
import bwie.com.mvpframe.Presenter.HomePresenterImpl;
import bwie.com.mvpframe.R;
import bwie.com.mvpframe.model.bean.HomeBean;
import bwie.com.mvpframe.view.IView;
import bwie.com.mvpframe.view.adapter.HomeRclAdapter;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/10/25
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class NewsFragment extends BaseFragment implements IView<HomeBean>, BaseFragment.OnFragmentInteractionListener {


    Unbinder unbinder;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.ll)
    LinearLayout mLl;
    @BindView(R.id.vp_container)
    RelativeLayout mVpContainer;
    @BindView(R.id.rev_news)
    RecyclerView mRevNews;
    @BindView(R.id.swipy)
    SwipyRefreshLayout mSwipy;

    private HomePresenterImpl mHomePresenter;

    private int[] strimage = new int[]{R.drawable.a, R.drawable.b,
            R.drawable.c, R.drawable.b, R.drawable.e};

    private ArrayList<ImageView> listImage;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (mVp != null) {
                        int currentItem = mVp.getCurrentItem();
                        currentItem++;
                        mVp.setCurrentItem(currentItem);
                        handler.sendEmptyMessageDelayed(0, 1000);
                    }
                    break;

                default:
                    break;
            }
        }

    };

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mHomePresenter = new HomePresenterImpl(this);
        mHomePresenter.loadData();

        //设置刷新时旋转的圆圈的颜色
        mSwipy.setColorSchemeColors(Color.RED, Color.YELLOW, Color.BLUE, Color.GRAY, Color.GREEN);
        //设置支持上啦刷新还是下拉加载,还是全都支持
        mSwipy.setDirection(SwipyRefreshLayoutDirection.BOTH);
        mSwipy.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(int index) {

                mSwipy.setRefreshing(false);
            }

            @Override
            public void onLoad(int index) {

                mSwipy.setRefreshing(false);
            }
        });
    }

    @Override
    protected void initView() {
        info();
        mVp.setAdapter(new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                return Integer.MAX_VALUE;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView iv = new ImageView(getContext());

                iv.setImageResource(strimage[position % strimage.length]);

                container.addView(iv);

                return iv;
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView((View) object);
            }
        });
        mVp.setCurrentItem(strimage.length * 5000);

        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                for (int i = 0; i < listImage.size(); i++) {
                    if (i == arg0 % strimage.length) {
                        listImage.get(i).setImageResource(R.drawable.dot_normal);
                    } else {
                        listImage.get(i).setImageResource(R.drawable.dot_focused);
                    }
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
        handler.sendEmptyMessageDelayed(0, 1000);
    }

    @Override
    public int setFragmentLayoutID() {
        return R.layout.news_fragment;
    }

    @Override
    public void onFragmentInteraction(Bundle bundle) {

    }

    @Override
    public void showOrHideErrorView(boolean flag) {

    }

    @Override
    public void showOrHideProgressBar(boolean flag) {

    }

    @Override
    public void refreshView(HomeBean homeBean) {
        if (homeBean != null) {
            List<HomeBean.StoriesBean> stories = homeBean.stories;
            mRevNews.setLayoutManager(new LinearLayoutManager(getContext()));
            mRevNews.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
            HomeRclAdapter homeRclAdapter = new HomeRclAdapter(getContext(), R.layout.home_rcl_item_layout, stories);
            mRevNews.setAdapter(homeRclAdapter);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mHomePresenter.detachView();
    }

    private void info() {
        listImage = new ArrayList<ImageView>();
        listImage.clear();
        for (int i = 0; i < strimage.length; i++) {
            ImageView iv = new ImageView(getContext());

            if (i == 0) {
                iv.setImageResource(R.drawable.dot_normal);
            } else {
                iv.setImageResource(R.drawable.dot_focused);
            }
            LayoutParams param = new LayoutParams(10, 10);
            param.setMargins(5, 0, 5, 5);
            listImage.add(iv);
            mLl.addView(iv, param);
        }
    }
}





