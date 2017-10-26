package bwie.com.mvpframe.utils;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/10/25
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/10/20
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：OKHTTP的应用拦截器
 */

public class MyOKApplicationInterceptor implements Interceptor {
    //拦截器
    //打印Log
    //替换header
    //缓存拦截器
    @Override
    public Response intercept(Chain chain) throws IOException {
        //替换header
       /* Request request = chain.request().newBuilder()
                .header("shenfen", "chinesse")
                .build();*/
       /* Request request = chain.request().newBuilder().build();

        //打印Log
        HttpUrl url = request.url();
        String httpUrl = url.url().toString();
        Log.e("TAG", "============" + httpUrl);
        Response response = chain.proceed(request);
        int code = response.code();
        Log.e("TAG", "============response.code() == " + code);*/

        //设置缓存时间为60秒，并移除了pragma消息头，移除它的原因是因为pragma也是控制缓存的一个消息头属性
        Response originResponse = chain.proceed(chain.request());

        //设置缓存时间为60秒，并移除了pragma消息头，移除它的原因是因为pragma也是控制缓存的一个消息头属性
        return originResponse.newBuilder().removeHeader("pragma")
                .header("Cache-Control", "max-age=60").build();
    }
//        return response;
}

