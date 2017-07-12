package zbf.process.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import zbf.process.R;
import zbf.process.service.MessengerService;

/**
 * 使用messenger(客户端)的界面
 */
public class ActivityMessenger extends AppCompatActivity
{
    /**
     * 与Service通信的信使对象
     */
    Messenger mService = null;
    /**
     * 服务绑定状态
     */
    boolean mBound = false;

    /**客户端绑定到服务
     * 1、实现ServiceConnection*/
    private ServiceConnection mConnection = new ServiceConnection()
    {
        /**传递服务中onBinid()方法返回的IBInder*/
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder)
        {
            /**客户端绑定到服务
             * 3、系统调用ServiceConnection回调方法时，可以使用接口定义的方法开始调用服务*/
            mService = new Messenger(iBinder);
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName)
        {
            mService = null;
            mBound = false;
        }
    };

    public void sayHello(View v)
    {
        if (!mBound) return;
        Message msg = Message.obtain(null, MessengerService.MSG_SAY_HELLO, 0, 0);
        try
        {
            mService.send(msg);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        /**客户端绑定到服务
         * 2、调用bindService()传递ServiceConnection实现*/
        bindService(new Intent(this, MessengerService.class), mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        if (mBound)
        {
            unbindService(mConnection);
            mBound = false;
        }
    }
}
