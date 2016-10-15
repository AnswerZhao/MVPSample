package me.zwdroid.mvpsample.commom;

import android.os.Bundle;

import java.util.HashMap;

import me.zwdroid.mvpsample.base.BaseFragment;
import me.zwdroid.mvpsample.ui.feed.FeedFragment;

/**
 * Author: zhaowenda
 * Email:  zwdroid@gmail.com
 * Date:   16/10/15 下午3:12
 */

public class FragmentFactory {

    public static final int TAB_ONE = 0;

    public static final int TAB_TWO = 1;

    public static final int TAB_THREE = 2;

    public static final int TAB_FOUR = 3;

    private static FragmentFactory instance;

    public static FragmentFactory getInstance()
    {
        if ( instance == null ) {
            instance = new FragmentFactory();
        }
        return instance;
    }

    private static HashMap<Integer, BaseFragment> mFragmentMap = new HashMap<Integer, BaseFragment>();

    public static BaseFragment createFragment(int position) {

        BaseFragment fragment = mFragmentMap.get(position);
        Bundle bundle = new Bundle();

        if (fragment == null) {
            switch (position) {
                case TAB_ONE:
                    fragment = new FeedFragment();
                    bundle.putString(BaseFragment.BUNDLE_KEY,"111111");
                    fragment.setArguments(bundle);
                    break;

                case TAB_TWO:
                    fragment = new FeedFragment();
                    bundle.putString(BaseFragment.BUNDLE_KEY,"2222222");
                    fragment.setArguments(bundle);
                    break;
                case TAB_THREE:
                    fragment = new FeedFragment();
                    bundle.putString(BaseFragment.BUNDLE_KEY,"3333333");
                    fragment.setArguments(bundle);
                    break;
                case TAB_FOUR:
                    fragment = new FeedFragment();
                    bundle.putString(BaseFragment.BUNDLE_KEY,"44444444");
                    fragment.setArguments(bundle);
                    break;
            }
            mFragmentMap.put(position, fragment);
        }

        return fragment;
    }
}
