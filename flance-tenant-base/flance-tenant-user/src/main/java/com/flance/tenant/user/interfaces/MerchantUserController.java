package com.flance.tenant.user.interfaces;

import com.flance.saas.tenant.domain.user.domain.vo.LoginUser;
import com.flance.saas.tenant.domain.user.domain.vo.MerchantUserRegisterVo;
import com.flance.saas.tenant.interfaces.user.MerchantUserInterface;
import com.flance.tenant.user.domain.LoginVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/merchant-user")
public class MerchantUserController {

    @Resource
    MerchantUserInterface merchantUserInterface;

    @PostMapping("/merchantLoginByPassword")
    public LoginUser merchantLoginByPassword(@RequestBody @Validated LoginVo loginVo) {
        return merchantUserInterface.login(loginVo.getUserAccount(), loginVo.getUserPassword());
    }

    @PostMapping("/register")
    public void register(@RequestBody @Validated MerchantUserRegisterVo merchantUserRegisterVo) {
        merchantUserInterface.registerMerchantUser(merchantUserRegisterVo.parseToEntity());
    }

}
