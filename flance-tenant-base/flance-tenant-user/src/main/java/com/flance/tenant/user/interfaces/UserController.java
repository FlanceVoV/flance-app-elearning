package com.flance.tenant.user.interfaces;

import com.flance.tenant.user.domain.LoginVo;
import com.flance.saas.tenant.domain.user.domain.vo.LoginUser;
import com.flance.saas.tenant.interfaces.user.SysUserInterface;
import com.flance.tenant.user.domain.LogoutVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    SysUserInterface sysUserInterface;

    @PostMapping("/sysLoginByPassword")
    public LoginUser sysLoginByPassword(@RequestBody LoginVo loginVo) {
        // 验证码校验


        return sysUserInterface.login(loginVo.getUserAccount(), loginVo.getUserPassword());
    }


    @PostMapping("/logout")
    public void logout(@RequestBody LogoutVo logoutVo) {
        sysUserInterface.logout(logoutVo.getUserId(), logoutVo.getToken());
    }


}
