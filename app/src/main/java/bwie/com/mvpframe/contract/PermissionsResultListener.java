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

public interface PermissionsResultListener {
    //同意申请的回调
    void onPermissionGranted();

    //拒绝申请的回调
    void onPermissionDenied();
}
