package bwie.com.mvpframe.view.fragment;

import android.os.Bundle;

import bwie.com.mvpframe.BaseFragment.BaseFragment;
import bwie.com.mvpframe.R;
import bwie.com.mvpframe.model.bean.HomeBean;
import bwie.com.mvpframe.view.IView;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/10/25
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class HotFragment extends BaseFragment implements IView<HomeBean>, BaseFragment.OnFragmentInteractionListener {
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public int setFragmentLayoutID() {
        return R.layout.hot_layout;
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

    }
}
