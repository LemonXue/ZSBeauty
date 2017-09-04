package com.xuewenhui.zsbeauty.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xuewenhui.zsbeauty.fragment.ShopFragment;

import java.util.List;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：17.8.25 9:58
 */
public class ShopPagerAdapter extends FragmentPagerAdapter {
    List<ShopFragment> mData;

    public ShopPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ShopPagerAdapter(FragmentManager fm, List<ShopFragment> data) {
        super(fm);
        mData = data;
    }

    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }
}
