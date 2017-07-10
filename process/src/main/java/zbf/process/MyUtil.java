package zbf.process;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by zbf on 2017/7/10.
 */

public class MyUtil
{
    public static int i;

    public static String getCurProcessName(Context context)
    {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                .getRunningAppProcesses())
        {
            if (appProcess.pid == pid)
            {

                return appProcess.processName;
            }
        }
        return null;
    }
}
