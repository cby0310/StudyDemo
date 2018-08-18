package com.cyb.test.mytest.mvp;

/**
 * Created by pc on 2017/10/24.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.PresenterImpl {

    @Override
    public void getCode(String phone) {
        getView().getCodeSuccess();
    }

    @Override
    public void login(String phone, String password) {
        getView().loginSuccess(null);
    }
}
