package zbf.zbf.presenter;

import zbf.zbf.model.LoginModel;
import zbf.zbf.model.LoginModleImpl;
import zbf.zbf.model.OnLoginFinishListener;
import zbf.zbf.view.LoginView;

/**
 * Created by zbf on 2017/7/7.
 */

public class LoginPresenterImpl implements LoginPresenter,OnLoginFinishListener
{
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginView loginView)
    {
        this.loginView = loginView;
        this.loginModel = new LoginModleImpl();
    }

    @Override
    public void presenter2Login(String username, String password)
    {

        loginModel.login(username,password,this);
    }

    @Override
    public void onDestory()
    {

    }

    @Override
    public void OnSuccess()
    {
        loginView.showToast(0);
    }

    @Override
    public void OnFeild()
    {
        loginView.showToast(1);
    }
}
