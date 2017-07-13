package zbf.process.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import zbf.process.IRemoteService;

/**
 *
 * Created by zbf on 2017/7/10.
 */
public class RemoteService extends Service
{
    IRemoteService iRemoteService;

    /**现在，当客户端（如 Activity）调用 bindService() 以连接此服务时，
     * 客户端的 onServiceConnected() 回调会接收服务的 onBind() 方法返回的 mBinder 实例*/
    @Override
    public IBinder onBind(Intent intent)
    {
        return mBinder;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();

    }

    private final IRemoteService.Stub mBinder = new IRemoteService.Stub()
    {

        @Override
        public int getPid() throws RemoteException
        {
            return Process.myPid();
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException
        {

        }
    };

    private ServiceConnection mConnection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder)
        {
            iRemoteService = IRemoteService.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName)
        {
            iRemoteService = null;
        }
    };

}
