package zbf.process.service;

import android.app.Service;
import android.content.Intent;
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
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
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
}
