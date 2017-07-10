package zbf.zbf.model;


import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by zbf on 2017/7/7.
 */

public class LoginModleImpl implements LoginModel
{
    @Override
    public void login(final String name, final String password, final OnLoginFinishListener listener)
    {
        //模拟登陆耗时操作
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password))
                    listener.OnSuccess();
                else
                    listener.OnFeild();
            }
        }, 2000);
    }

}
