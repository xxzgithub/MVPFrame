package bwie.com.mvpframe.contract;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/10/25
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public interface CallBackListener<T> {
    void onStart();

    void onSuccess(T result);

    void onFail(T result);
}
