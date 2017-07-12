package zbf.process.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;

/**
 * 使用Messenger(服务)的服务样例
 */
public class MessengerService extends Service
{
    /**
     * 只是服务显示消息
     */
    public static final int MSG_SAY_HELLO = 1;

    /**
     * 处理从客户端发来的消息
     */
    class IncomingHandler extends Handler
    {
        @Override
        public void handleMessage(Message msg)
        {
            Log.e("zbf",msg.toString());
            switch (msg.what)
            {
                case MSG_SAY_HELLO:
                    Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }

    /**
     * 通过客户端发送消息的目标
     */
    final Messenger mMessenger = new Messenger(new IncomingHandler());

    /**
     * 当绑定服务的时候，返回一个接口给messenger
     * 为了发送消息到服务
     */
    @Override
    public IBinder onBind(Intent intent)
    {
        Toast.makeText(getApplicationContext(),"Binding",Toast.LENGTH_SHORT).show();
        return mMessenger.getBinder();
    }


}
