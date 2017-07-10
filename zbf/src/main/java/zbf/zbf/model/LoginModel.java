package zbf.zbf.model;

/**
 *
 * Created by zbf on 2017/7/7.
 */
public interface LoginModel
{
    void login(String name,String password,OnLoginFinishListener listener);
}
