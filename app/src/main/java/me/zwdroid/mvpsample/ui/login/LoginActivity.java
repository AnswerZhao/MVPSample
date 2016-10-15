package me.zwdroid.mvpsample.ui.login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import me.zwdroid.mvpsample.R;
import me.zwdroid.mvpsample.base.BaseActivity;

import static me.zwdroid.mvpsample.util.Preconditions.checkNotNull;

/**
 * Author: zhaowenda
 * Email:  zwdroid@gmail.com
 * Date:   16/10/15 下午5:16
 */

public class LoginActivity extends BaseActivity implements LoginConract.View,View.OnClickListener {

    private EditText etName;
    private EditText etPwd;
    private Button mLogin;
    private Button mClear;


    private LoginConract.Presenter mPresenter;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = (EditText) findViewById(R.id.et_name);
        etPwd = (EditText) findViewById(R.id.et_pwd);

        mLogin = (Button) findViewById(R.id.login);
        mClear = (Button) findViewById(R.id.clear);
        mLogin.setOnClickListener(this);
        mClear.setOnClickListener(this);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMax(100);
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.setCancelable(false);

        mPresenter = new LoginPresenter(this);
    }

    @Override
    public void setPresenter(LoginConract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void clearText() {
        etName.setText("");
        etPwd.setText("");
        etName.requestFocus();
    }

    @Override
    public void loginResult(boolean result) {
        if (result) {
            Snackbar.make(mLogin,"登录成功",Snackbar.LENGTH_SHORT).show();
        }else{
            Snackbar.make(mLogin,"登录失败",Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setLoading(boolean active) {
        if (active) {
            mProgressDialog.setMessage("加载中.....");
            mProgressDialog.show();
        }else{
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.clear:
                mPresenter.clear();
                break;
            case R.id.login:
                mPresenter.doLogin(etName.getText().toString(),etPwd.getText().toString());
                break;
        }
    }

}
