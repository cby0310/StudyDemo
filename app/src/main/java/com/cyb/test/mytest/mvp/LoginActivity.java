package com.cyb.test.mytest.mvp;

import android.os.Bundle;

import com.cyb.test.mytest.R;
import com.cyb.test.mytest.retrofit.UserInfo;

public class LoginActivity extends MVPBaseAcitivity<LoginContract.View, LoginPresenter> implements LoginContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPresenter.getCode("110");
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void getCodeSuccess() {

    }

    @Override
    public void loginSuccess(UserInfo userInfo) {

    }
}
