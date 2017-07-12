package zbf.process.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import zbf.process.R;
import zbf.process.service.LocalService;

/**
 * 绑定到LocalService的界面
 */
public class BindingActivity extends AppCompatActivity
{
    Button btn_unbind;
    LocalService mService;
    //绑定状态
    boolean mBound = false;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binding);
        btn_unbind = (Button) findViewById(R.id.btn_unbind);
        btn_unbind.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (mBound){
                    //从服务中调用获取随机数的方法
                    int num = mService.getRandomNumber();
                    Toast.makeText(BindingActivity.this,"num:" + num,Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_unbind.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View view)
            {
                startActivity(new Intent(BindingActivity.this,ActivityMessenger.class));
                return true;
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        //绑定到LocalService
        Intent bindIntent = new Intent(this,LocalService.class);
        bindService(bindIntent,mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        //解绑服务
        if (mBound){
            unbindService(mConnection);
            mBound = false;
        }
    }

    /**服务绑定回调，传递给bindService()*/
    private ServiceConnection mConnection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder)
        {
            //绑定服务之后将IBinder获取并转发给服务实例（也就是这里的 LocalService）
            LocalService.LocalBinder binder = (LocalService.LocalBinder) iBinder;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName)
        {
            mBound = false;
        }
    };



}
