package com.flance.tenant.user.domain;

import lombok.Data;

@Data
public class LoginVo {

    private String userAccount;

    private String userPhone;

    private String userPassword;

    private String verifyCode;

    private String smsCode;

}
