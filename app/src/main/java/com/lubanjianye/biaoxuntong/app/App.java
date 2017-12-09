package com.lubanjianye.biaoxuntong.app;

import android.app.Application;

import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.helper.ExceptionHandler;

/**
 * 项目名:   AppLunious
 * 包名:     com.lubanjianye.biaoxuntong.app
 * 文件名:   App
 * 创建者:   lunious
 * 创建时间: 2017/12/8  23:58
 * 描述:     TODO
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fragmentation.builder()
                // 设置 栈视图 模式为 悬浮球模式   SHAKE: 摇一摇唤出  默认NONE：隐藏， 仅在Debug环境生效
                .stackViewMode(Fragmentation.NONE)
                // 开发环境：true时，遇到异常："Can not perform this action after onSaveInstanceState!"时，抛出，并Crash;
                // 生产环境：false时，不抛出，不会Crash，会捕获，可以在handleException()里监听到
                .debug(true) // 实际场景建议.debug(BuildConfig.DEBUG)
                // 生产环境时，捕获上述异常（避免crash），会捕获
                // 建议在回调处上传下面异常到崩溃监控服务器
                .handleException(new ExceptionHandler() {
                    @Override
                    public void onException(Exception e) {
                        // 以Bugtags为例子: 把捕获到的 Exception 传到 Bugtags 后台。
                        // Bugtags.sendException(e);
                    }
                })
                .install();

    }
}
