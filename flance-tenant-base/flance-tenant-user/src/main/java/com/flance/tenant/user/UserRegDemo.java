package com.flance.tenant.user;

import com.alibaba.nacos.common.utils.MD5Utils;
import com.flance.tenant.user.domain.LoginVo;
import com.flance.web.utils.GsonUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRegDemo {

    public static void main(String[] args) {
        String accountName = "test2";
        String password = "123456";
        String passwordEncode = MD5Utils.md5Hex(password, "UTF-8");
        System.out.println(passwordEncode);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        password = encoder.encode(accountName + passwordEncode);
        LoginVo loginVo = new LoginVo();
        loginVo.setUserAccount(accountName);
        loginVo.setUserPassword(password);
        System.out.println(GsonUtils.toJSONString(loginVo));
    }

}
