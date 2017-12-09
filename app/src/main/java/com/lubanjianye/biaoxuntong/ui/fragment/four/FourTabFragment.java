package com.lubanjianye.biaoxuntong.ui.fragment.four;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lubanjianye.biaoxuntong.R;
import com.lubanjianye.biaoxuntong.ui.fragment.base.BaseMainFragment;

import me.yokeyword.eventbusactivityscope.EventBusActivityScope;

/**
 * 项目名:   AppLunious
 * 包名:     com.lubanjianye.biaoxuntong.ui.fragment
 * 文件名:   FirstTabFragment
 * 创建者:   lunious
 * 创建时间: 2017/12/9  0:33
 * 描述:     TODO
 */

public class FourTabFragment extends BaseMainFragment {


    public static FourTabFragment newInstance() {

        Bundle args = new Bundle();

        FourTabFragment fragment = new FourTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_four, container, false);
        return view;
    }

}
