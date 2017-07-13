package zbf.process.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zbf.process.IRemoteService;
import zbf.process.R;

/**
 * 调用AIDL创建的服务
 * TODO 需要官方API sample demo
 */
public class BindAIDLActivity extends AppCompatActivity
{
    IRemoteService mService = null;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_aidl);
    }



}
