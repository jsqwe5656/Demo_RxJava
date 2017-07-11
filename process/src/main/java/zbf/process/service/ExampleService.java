package zbf.process.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;

/**
 * 实现服务生命周期回调
 */
public class ExampleService extends Service
{
    int mStartMode;         //指示如果服务被杀死的行为
    IBinder mBinder;        //被绑定的接口
    boolean mAllowRebind;   //重新绑定时的状态

    @Override
    public void onCreate()
    {
        //服务被创建
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        //服务在调用startService()之后处于运行状态
        return mStartMode;
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        //组件通过bindService()来绑定服务
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent)
    {
        //通过unbindService()方法解绑
        return mAllowRebind;
    }

    @Override
    public void onRebind(Intent intent)
    {
        //组件通过bindService()来绑定服务
        //在解绑之后再次绑定时被调用
    }

    @Override
    public void onDestroy()
    {
        //服务太久不被使用被回收或者主动调用销毁服务时被调用
    }
}
