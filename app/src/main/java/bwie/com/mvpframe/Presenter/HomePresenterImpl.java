package bwie.com.mvpframe.Presenter;

import bwie.com.mvpframe.contract.CallBackListener;
import bwie.com.mvpframe.model.HomeModel;
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

public class HomePresenterImpl implements IHomePresenter {
    private IView mIview;

    public HomePresenterImpl(IView iView) {
        this.mIview = iView;
    }

    private HomePresenterImpl() {
    }

    @Override
    public void loadData() {
        HomeModel.getIntsance().getData(new CallBackListener<HomeBean>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(HomeBean result) {
                if (result != null) {
                    mIview.refreshView(result);
                }
            }

            @Override
            public void onFail(HomeBean result) {

            }
        });
    }

    @Override
    public void detachView() {
        if (mIview != null) {
            mIview = null;
        }
    }
}
