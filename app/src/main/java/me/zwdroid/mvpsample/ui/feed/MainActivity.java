package me.zwdroid.mvpsample.ui.feed;

import android.os.Bundle;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import me.zwdroid.mvpsample.R;
import me.zwdroid.mvpsample.base.BaseActivity;
import me.zwdroid.mvpsample.commom.FragmentFactory;
import me.zwdroid.mvpsample.util.ActivityUtils;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener,View.OnClickListener{

    private BottomNavigationBar mBottomNavigationBar;
    // 记录当前位置
    int lastSelectedPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.setTabSelectedListener(this);

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),FragmentFactory.createFragment(0),R.id.container_view);


        resetNavigationBar();
    }

    private void resetNavigationBar(){

        mBottomNavigationBar.clearAll();

        mBottomNavigationBar
                .setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_home_white_24dp, "Home").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.mipmap.ic_book_white_24dp, "Books").setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.mipmap.ic_music_note_white_24dp, "Music").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.mipmap.ic_tv_white_24dp, "Movies & TV").setActiveColorResource(R.color.brown))
                .setFirstSelectedPosition(lastSelectedPosition > 3 ? 3 : lastSelectedPosition)
                .initialise();
    }

    @Override
    public void onTabSelected(int position) {
        lastSelectedPosition = position;
        switchFragment(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }


    private void switchFragment(int position) {
        ActivityUtils.switchFragmentToActivity(getSupportFragmentManager(),FragmentFactory.createFragment(position),R.id.container_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
}
