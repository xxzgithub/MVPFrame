package bwie.com.mvpframe.model;

import java.io.IOException;

import bwie.com.mvpframe.constanturl.Constant;
import bwie.com.mvpframe.contract.CallBackListener;
import bwie.com.mvpframe.model.bean.HomeBean;
import bwie.com.mvpframe.utils.OkHttp;
import okhttp3.Request;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/10/25
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class HomeModel {
    private static volatile HomeModel intsance;

    private HomeModel() {
    }

    public static HomeModel getIntsance() {
        if (intsance == null) {
            synchronized (HomeModel.class) {
                if (intsance == null) {
                    intsance = new HomeModel();
                }
            }
        }
        return intsance;
    }

    //请求数据的方法
    public void getData(String path, final CallBackListener<HomeBean> callBackListener) {
        OkHttp.getAsync(getJsonUrl(path), new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {
                callBackListener.onFail(null);
            }

            @Override
            public void requestSuccess(String result) throws Exception {
                if (result != null) {
                    HomeBean homeBean = HomeBean.objectFromData(result);
                    callBackListener.onSuccess(homeBean);
                }
            }
        });
    }

    public String getJsonUrl(String path) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(Constant.Urlcontainer.Baseweather)
                .append(path);
                /*.append("pscid=")
                .append(page + "");*/
        return buffer.toString();
    }

    /*public String getJsonUrl(int page) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(Constant.Urlcontainer.Baseweather)
                .append("news/latest");
                *//*.append("pscid=")
                .append(page + "");*//*
        return buffer.toString();
    }*/
}
