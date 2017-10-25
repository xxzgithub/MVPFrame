package bwie.com.mvpframe.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwie.com.mvpframe.R;
import bwie.com.mvpframe.cutsomview.CircleView;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/10/25
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class NavActivity extends AppCompatActivity {
    @BindView(R.id.main_rv)
    CircleView mMainRv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        ButterKnife.bind(this);
        WindowManager wm = this.getWindowManager();
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        float curTranslationX = mMainRv.getTranslationX();
        float curTranslationY = mMainRv.getTranslationY();
        ObjectAnimator animator = ObjectAnimator.ofFloat(mMainRv, "translationX", curTranslationX, width);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mMainRv, "translationY", curTranslationY, height);
        AnimatorSet animSet = new AnimatorSet();
        animSet.playTogether(animator, animator1);
        animSet.setInterpolator(new LinearInterpolator());
        animSet.setDuration(5000);
        animSet.start();
        animSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                startActivity(new Intent(NavActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
}
