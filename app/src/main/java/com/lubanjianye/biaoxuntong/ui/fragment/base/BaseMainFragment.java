package com.lubanjianye.biaoxuntong.ui.fragment.base;

import android.widget.Toast;

import com.lubanjianye.biaoxuntong.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 项目名:   AppLunious
 * 包名:     com.lubanjianye.biaoxuntong.ui.fragment.base
 * 文件名:   BaseMainFragment
 * 创建者:   lunious
 * 创建时间: 2017/12/9  0:35
 * 描述:     TODO
 */

public class BaseMainFragment extends SupportFragment {

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    /**
     * 处理回退事件
     *
     * @return
     */
    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(_mActivity, R.string.press_again_exit, Toast.LENGTH_SHORT).show();
        }
        return true;
    }


}
