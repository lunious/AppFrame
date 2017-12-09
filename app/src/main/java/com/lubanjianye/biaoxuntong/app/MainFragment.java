package com.lubanjianye.biaoxuntong.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lubanjianye.biaoxuntong.R;
import com.lubanjianye.biaoxuntong.event.TabSelectedEvent;
import com.lubanjianye.biaoxuntong.ui.fragment.first.FirstTabFragment;
import com.lubanjianye.biaoxuntong.ui.fragment.five.FiveTabFragment;
import com.lubanjianye.biaoxuntong.ui.fragment.four.FourTabFragment;
import com.lubanjianye.biaoxuntong.ui.fragment.second.SecondTabFragment;
import com.lubanjianye.biaoxuntong.ui.fragment.third.ThirdTabFragment;
import com.lubanjianye.biaoxuntong.ui.view.botton.BottomBar;
import com.lubanjianye.biaoxuntong.ui.view.botton.BottomBarTab;

import me.yokeyword.eventbusactivityscope.EventBusActivityScope;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * 项目名:   AppLunious
 * 包名:     com.lubanjianye.biaoxuntong.app
 * 文件名:   MainFragment
 * 创建者:   lunious
 * 创建时间: 2017/12/9  0:13
 * 描述:     TODO
 */

public class MainFragment extends SupportFragment {

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOUR = 3;
    public static final int FIVE = 4;

    private SupportFragment[] mFragments = new SupportFragment[5];

    private BottomBar mBottomBar;

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SupportFragment firstFragment = findChildFragment(FirstTabFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = FirstTabFragment.newInstance();
            mFragments[SECOND] = SecondTabFragment.newInstance();
            mFragments[THIRD] = ThirdTabFragment.newInstance();
            mFragments[FOUR] = FourTabFragment.newInstance();
            mFragments[FIVE] = FiveTabFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_tab_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOUR],
                    mFragments[FIVE]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findChildFragment(SecondTabFragment.class);
            mFragments[THIRD] = findChildFragment(ThirdTabFragment.class);
            mFragments[FOUR] = findChildFragment(FourTabFragment.class);
            mFragments[FIVE] = findChildFragment(FiveTabFragment.class);
        }
    }


    private void initView(View view) {

        mBottomBar = (BottomBar) view.findViewById(R.id.bottomBar);
        mBottomBar
                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_launcher, getString(R.string.first)))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_launcher, getString(R.string.second)))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_launcher, getString(R.string.third)))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_launcher, getString(R.string.four)))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_launcher, getString(R.string.five)));


        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                // 在FirstPagerFragment,FirstHomeFragment中接收, 因为是嵌套的Fragment
                // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
                EventBusActivityScope.getDefault(_mActivity).post(new TabSelectedEvent(position));
            }
        });
    }

    /**
     * start other BrotherFragment
     */
    public void startBrotherFragment(SupportFragment targetFragment) {
        start(targetFragment);
    }


}
