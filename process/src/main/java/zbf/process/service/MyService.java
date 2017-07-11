package zbf.process.service;

import android.app.Service;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.widget.Toast;


/**
 * 对照官方api实现与IntentService一样功能的service 即 对于每个启动请求，均使用工作线程执行，切每次处理一个请求
 */
public class MyService extends Service
{
    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;

    private final class ServiceHandler extends Handler
    {
        public ServiceHandler(Looper looper)
        {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg)
        {
            try
            {
                Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            stopSelf(msg.arg1);
        }
    }

    @Override
    public void onCreate()
    {
        HandlerThread thread = new HandlerThread("zbf", Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();
        // Get the HandlerThread's Looper and use it for our Handler
        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        //返回值必须是系统提供的几个常量之一
        //如果被杀死在返回到这的时候会重启
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        //不提供绑定则返回null
        return null;
    }

    @Override
    public void onDestroy()
    {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
    }
}
