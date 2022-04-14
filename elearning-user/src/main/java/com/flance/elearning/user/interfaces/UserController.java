package com.flance.elearning.user.interfaces;

import com.flance.elearning.user.domain.LoginVo;
import com.flance.saas.tenant.domain.user.domain.vo.LoginUser;
import com.flance.saas.tenant.interfaces.user.SysUserInterface;
import com.flance.web.utils.GsonUtils;
import com.flance.web.utils.RsaUtil;
import com.flance.web.utils.web.request.GatewayRequest;
import com.flance.web.utils.web.response.WebResponse;
import com.google.common.collect.Maps;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    SysUserInterface sysUserInterface;

    @PostMapping("/sysLogin")
    public LoginUser sysLogin(@RequestBody LoginVo loginVo) {
        return sysUserInterface.login(loginVo.getUserAccount(), loginVo.getUserPassword());
    }

}
