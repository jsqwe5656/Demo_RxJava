package zbf.process.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

/**
 * 让客户端可以通过Binder实现访问服务中的方法
 */
public class LocalService extends Service
{
    private IBinder mBinder = new LocalBinder();
    private Random mGenerator = new Random();

    public class LocalBinder extends Binder
    {
        LocalService getService()
        {
            //返回这个实例让客户端可以访问公用方法
            return LocalService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return mBinder;
    }

    /**给客户端调用的公用方法**/
    public int getRandomNumber()
    {
        return mGenerator.nextInt(100);
    }

}
