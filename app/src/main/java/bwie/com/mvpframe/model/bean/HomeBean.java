package bwie.com.mvpframe.model.bean;

import java.util.List;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/10/25
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class HomeBean {

    /**
     * date : 20171025
     * stories : [{"images":["https://pic3.zhimg.com/v2-ed8af5cd65b6bca6c9b4966b05e1b72a.jpg"],"type":0,"id":9653414,"ga_prefix":"102510","title":"虽说「人心狠毒」，为什么很少见到真正有毒的哺乳动物？"},{"images":["https://pic4.zhimg.com/v2-c48d2c752ec7b8b183055667b76596c7.jpg"],"type":0,"id":9653540,"ga_prefix":"102509","title":"没和身边人一起进大律所，可后来，我却学得比他们多"},{"images":["https://pic3.zhimg.com/v2-8d3803d6014153f1aa9835b47ccd7db2.jpg"],"type":0,"id":9653658,"ga_prefix":"102508","title":"没有「爆裂脑花」、细思 bug 极多\u2026\u2026唯一的亮点只剩特工代号"},{"images":["https://pic3.zhimg.com/v2-8569d560d951c65cc1c712b8976c8fba.jpg"],"type":0,"id":9653620,"ga_prefix":"102507","title":"身为杂食性动物的两脚兽，我们要吃蔬菜水果，喵汪星人呢？"},{"images":["https://pic2.zhimg.com/v2-340313b0e29d374f9a7fbe3cb45483e1.jpg"],"type":0,"id":9653718,"ga_prefix":"102507","title":"姚老板的球队能卖多少钱，起决定作用的是他另一个身份"},{"images":["https://pic3.zhimg.com/v2-d839d13157eb525ed60c34e39fee4d1a.jpg"],"type":0,"id":9653251,"ga_prefix":"102507","title":"《天才枪手》式的造富神话：非典型批片、中国采购团和弯道超车梦"},{"images":["https://pic1.zhimg.com/v2-ea05acac99ff29b8d1b60de506dbcfe4.jpg"],"type":0,"id":9653582,"ga_prefix":"102506","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic2.zhimg.com/v2-e7582788c34b9d40b7b849ea3458d0dd.jpg","type":0,"id":9653718,"ga_prefix":"102507","title":"姚老板的球队能卖多少钱，起决定作用的是他另一个身份"},{"image":"https://pic1.zhimg.com/v2-e5b5e2342378517d1ddeb3f26496367c.jpg","type":0,"id":9653251,"ga_prefix":"102507","title":"《天才枪手》式的造富神话：非典型批片、中国采购团和弯道超车梦"},{"image":"https://pic3.zhimg.com/v2-3820a42752377cd7cbceff405d79e182.jpg","type":0,"id":9653770,"ga_prefix":"102419","title":"对我来说，《英雄联盟》全球总决赛就是最好的体育赛事"},{"image":"https://pic1.zhimg.com/v2-035ee11f84858c12173d1004d49b5d88.jpg","type":0,"id":9653488,"ga_prefix":"102415","title":"为什么 AI 都打败李世石、柯洁了，还是没法帮我洗裤衩、做饭？"},{"image":"https://pic3.zhimg.com/v2-2d2d4ab0075d0fa149e52bcc170164e6.jpg","type":0,"id":9653668,"ga_prefix":"102414","title":"印度送餐产业：多少商学院和大企业想学习，却很难复制"}]
     */

    public String date;
    public List<StoriesBean> stories;
    public List<TopStoriesBean> top_stories;

    public static HomeBean objectFromData(String str) {

        return new com.google.gson.Gson().fromJson(str, HomeBean.class);
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic3.zhimg.com/v2-ed8af5cd65b6bca6c9b4966b05e1b72a.jpg"]
         * type : 0
         * id : 9653414
         * ga_prefix : 102510
         * title : 虽说「人心狠毒」，为什么很少见到真正有毒的哺乳动物？
         */

        public int type;
        public int id;
        public String ga_prefix;
        public String title;
        public List<String> images;

        public static StoriesBean objectFromData(String str) {

            return new com.google.gson.Gson().fromJson(str, StoriesBean.class);
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic2.zhimg.com/v2-e7582788c34b9d40b7b849ea3458d0dd.jpg
         * type : 0
         * id : 9653718
         * ga_prefix : 102507
         * title : 姚老板的球队能卖多少钱，起决定作用的是他另一个身份
         */

        public String image;
        public int type;
        public int id;
        public String ga_prefix;
        public String title;

        public static TopStoriesBean objectFromData(String str) {

            return new com.google.gson.Gson().fromJson(str, TopStoriesBean.class);
        }
    }
}
