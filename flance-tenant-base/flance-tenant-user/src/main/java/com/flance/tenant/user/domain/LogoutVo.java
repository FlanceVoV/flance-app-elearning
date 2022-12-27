package com.flance.tenant.user.domain;

import lombok.Data;

@Data
public class LogoutVo {

    private String userId;

    private String token;

}
