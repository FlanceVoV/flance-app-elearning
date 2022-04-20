package com.flance.tenant.tenant.interfaces;

import com.flance.saas.tenant.domain.vo.TenantRegisterRequest;
import com.flance.saas.tenant.domain.vo.TenantRegisterResponse;
import com.flance.saas.tenant.interfaces.tenant.TenantInterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/tenant")
public class TenantController {

    @Resource
    private TenantInterface tenantInterface;

    @PostMapping("/register")
    public TenantRegisterResponse register(@Valid TenantRegisterRequest request) {
        return tenantInterface.register(request);
    }

}
