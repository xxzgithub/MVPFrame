package bwie.com.mvpframe.view;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/10/25
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public interface IView<T> {
    //容错页
    void showOrHideErrorView(boolean flag);

    //进度条
    void showOrHideProgressBar(boolean flag);

    //刷新数据
    void refreshView(T t);
}
