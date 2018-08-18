package com.cyb.test.mytest.mvp;

import com.cyb.test.mytest.retrofit.UserInfo;

/**
 * Created by pc on 2017/10/24.
 */

public interface LoginContract {
    interface View {
        /**
         * 获取验证码成功回调
         */
        void getCodeSuccess();

        /**
         * 登录成功回调
         */
        void loginSuccess(UserInfo userInfo);
    }

    /**
     * P基类
     */
    interface PresenterImpl {
        /**
         * 获取验证码
         *
         * @param phone 手机号
         */
        void getCode(String phone);

        /**
         * 账号登录
         *
         * @param phone    手机号
         * @param password 密码
         */
        void login(String phone, String password);
    }
}
