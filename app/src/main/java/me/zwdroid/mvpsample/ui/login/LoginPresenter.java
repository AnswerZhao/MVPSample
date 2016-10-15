package me.zwdroid.mvpsample.ui.login;

import android.os.Handler;
import android.support.annotation.NonNull;

import static me.zwdroid.mvpsample.util.Preconditions.checkNotNull;

/**
 * Author: zhaowenda
 * Email:  zwdroid@gmail.com
 * Date:   16/10/15 下午5:37
 */

public class LoginPresenter implements LoginConract.Presenter {

    @NonNull
    private LoginConract.View mLoginView;

    public LoginPresenter(LoginConract.View loginView) {
        mLoginView = checkNotNull(loginView,"loginView cannot be null");
        mLoginView.setPresenter(this);
    }

    @Override
    public void clear() {
        mLoginView.clearText();
    }

    @Override
    public void doLogin(String name, String pwd) {
        mLoginView.setLoading(true);
        if (name.equals("123") && pwd.equals("123")) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mLoginView.loginResult(true);
                    mLoginView.setLoading(false);
                }
            },1000);

        }else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mLoginView.loginResult(false);
                    mLoginView.setLoading(false);
                }
            },1000);
        }
    }

    @Override
    public void subscribe() {
        // 加载数据
    }

    @Override
    public void unsubscribe() {
        // 关闭资源
    }
}
