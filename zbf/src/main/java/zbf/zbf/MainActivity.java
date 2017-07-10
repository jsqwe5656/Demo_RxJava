package zbf.zbf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import zbf.zbf.presenter.LoginPresenter;
import zbf.zbf.presenter.LoginPresenterImpl;
import zbf.zbf.view.LoginView;


/**
 * 尝试mvp模式的demo
 */
public class MainActivity extends AppCompatActivity implements LoginView
{
    private EditText et_name, et_passwd;
    private Button btn_login, btn_cancle;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewInit();

        presenter = new LoginPresenterImpl(this);
    }

    private void viewInit()
    {
        et_name = (EditText) findViewById(R.id.et_name);
        et_passwd = (EditText) findViewById(R.id.et_passwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                presenter.presenter2Login(et_name.getText().toString(),et_passwd.getText().toString());
            }
        });
        btn_cancle = (Button) findViewById(R.id.btn_cancle);
        btn_cancle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                clearText();
            }
        });
    }

    private void clearText()
    {
        et_name.setText("");
        et_passwd.setText("");
    }


    @Override
    public void showToast(int mode)
    {
        String text;
        if (mode == 0)
            text = "Success";
        else
            text = "Feild";
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}
