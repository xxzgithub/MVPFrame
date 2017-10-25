package bwie.com.mvpframe.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import bwie.com.mvpframe.BaseFragment.BaseFragment;
import bwie.com.mvpframe.R;
import bwie.com.mvpframe.view.adapter.MyViewPager;
import bwie.com.mvpframe.view.fragment.HotFragment;
import bwie.com.mvpframe.view.fragment.NewsFragment;
import bwie.com.mvpframe.view.fragment.SpecialFragment;
import bwie.com.mvpframe.view.fragment.ThemeFragment;

public class MainActivity extends AppCompatActivity implements BaseFragment.OnFragmentInteractionListener {

    private TabLayout tab_FindFragment_title;
    private ViewPager vp_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        ArrayList<String> title = new ArrayList<>();
        title.add("最新日报");
        title.add("热门");
        title.add("专栏");
        title.add("主题日报");

        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(title.get(0)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(title.get(1)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(title.get(2)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(title.get(3)));

        //初始化Fragment
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new NewsFragment());
        fragmentList.add(new HotFragment());
        fragmentList.add(new SpecialFragment());
        fragmentList.add(new ThemeFragment());

        MyViewPager myViewPager = new MyViewPager(getSupportFragmentManager(), fragmentList, title);

        vp_main.setAdapter(myViewPager);

        tab_FindFragment_title.setupWithViewPager(vp_main);
    }

    private void initView() {
        tab_FindFragment_title = (TabLayout) findViewById(R.id.tab_FindFragment_title);
        vp_main = (ViewPager) findViewById(R.id.vp_main);
    }

    @Override
    public void onFragmentInteraction(Bundle bundle) {

    }
}
