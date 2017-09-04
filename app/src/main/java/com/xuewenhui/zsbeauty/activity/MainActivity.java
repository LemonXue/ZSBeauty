package com.xuewenhui.zsbeauty.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.xuewenhui.zsbeauty.R;
import com.xuewenhui.zsbeauty.adapter.ShopPagerAdapter;
import com.xuewenhui.zsbeauty.fragment.ShopFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.leibnik.wechatradiobar.WeChatRadioGroup;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.radiogroup)
    WeChatRadioGroup gradualRadioGroup;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        // 设置为全屏 否则只隐藏title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ButterKnife.bind(this);
        initView();
        initListener();
        Looper.prepareMainLooper();
    }


    private void initListener() {
    }

    private void initView() {
        List<ShopFragment> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ShopFragment fragment = new ShopFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            fragment.setArguments(bundle);
            list.add(fragment);
        }
        viewPager.setAdapter(new ShopPagerAdapter(getSupportFragmentManager(), list));
        gradualRadioGroup.setViewPager(viewPager);
    }
}
