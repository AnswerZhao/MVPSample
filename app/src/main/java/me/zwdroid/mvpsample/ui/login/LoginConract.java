package me.zwdroid.mvpsample.ui.login;

import me.zwdroid.mvpsample.base.BasePresenter;
import me.zwdroid.mvpsample.base.BaseView;

/**
 * Author: zhaowenda
 * Email:  zwdroid@gmail.com
 * Date:   16/10/15 下午5:16
 */

public interface LoginConract {

    interface View extends BaseView<Presenter>{
        void clearText();
        void loginResult(boolean result);
        void setLoading(boolean active);
    }

    interface Presenter extends BasePresenter{
        void clear();
        void doLogin(String name,String pwd);
    }
}
