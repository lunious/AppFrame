package com.lubanjianye.biaoxuntong.ui.fragment.third;


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

public class ThirdTabFragment extends BaseMainFragment {


    public static ThirdTabFragment newInstance() {

        Bundle args = new Bundle();

        ThirdTabFragment fragment = new ThirdTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_third, container, false);
        return view;
    }


}
