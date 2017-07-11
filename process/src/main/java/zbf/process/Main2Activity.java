package zbf.process;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import zbf.process.service.MyService;

/**
 * android 多进程测试Demo
 */
public class Main2Activity extends AppCompatActivity
{
    private TextView tv1, tv2, tv3, tv4, tv5, tv6;
    private Button bt;
    private List<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();
        initData();
    }

    private void initData()
    {
        list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++)
        {
            list.add(i + "aaaaaaaaaaaaa");
        }
        int i = MyUtil.i;
        tv1.setText("当前线程id:" + Thread.currentThread().getId());
        tv2.setText("当前进程Pid:" + android.os.Process.myPid());
        tv3.setText("当前进程名称:" + MyUtil.getCurProcessName(this));
        tv4.setText("全局静态变量i:" + i);
        tv5.setText("当前申请的总内存:" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
        tv6.setText("单个进程分配的内存上限:" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");

    }

    private void initView()
    {
        final Intent intent = new Intent(Main2Activity.this,MyService.class);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        bt = (Button) findViewById(R.id.btn_jump);
        bt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startService(intent);
            }
        });
        bt.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View view)
            {
                stopService(intent);
                return true;
            }
        });

    }
}
