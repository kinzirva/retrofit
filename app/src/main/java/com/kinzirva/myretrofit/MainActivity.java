package com.kinzirva.myretrofit;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kinzirva.myretrofit.activity.NewsFragment;
import com.kinzirva.myretrofit.activity.SearchImageFragment;
import com.kinzirva.myretrofit.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kinzirva on 2017/1/23.
 */


public class MainActivity extends BaseActivity {
    @BindView(R.id.toolbars)
    Toolbar mToolbar;

    @BindView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.navigationView)
    NavigationView mNavigationView;

    private SearchImageFragment searchImageFragment;
    private NewsFragment newsFragment;

    @Override
    public void setContentView() {
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);

        initFragment();
    }

    @Override
    public void updateKinds() {
        super.updateKinds();
    }

    @Override
    public void initData() {
        //设置主标题
        mToolbar.setTitle("搜索图片");

    }

    @Override
    public void setListener() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.menu_search_img) {
                    mDrawerLayout.closeDrawer(Gravity.LEFT);
                    mToolbar.setTitle("搜索图片");

                    switchFragment(searchImageFragment);
                } else if (menuItem.getItemId() == R.id.menu_news) {
                    mDrawerLayout.closeDrawer(Gravity.LEFT);
                    mToolbar.setTitle("新闻");
                    switchFragment(newsFragment);
                }
                return false;
            }
        });

    }

    private void initFragment() {
        searchImageFragment = new SearchImageFragment();
        newsFragment = new NewsFragment();
        mTempFragment = searchImageFragment;
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, mTempFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void invalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Fragment mTempFragment;

    private void switchFragment(Fragment fragment) {
        if (fragment != mTempFragment) {
            if (!fragment.isAdded()) {
                getSupportFragmentManager().beginTransaction().hide(mTempFragment)
                        .add(R.id.main_container, fragment).commit();
            } else {
                getSupportFragmentManager().beginTransaction().hide(mTempFragment)
                        .show(fragment).commit();
            }
            mTempFragment = fragment;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click();
        }
        return false;
    }

    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit;
        if (!isExit) {
            isExit = true;
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;
                }
            }, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }
}
