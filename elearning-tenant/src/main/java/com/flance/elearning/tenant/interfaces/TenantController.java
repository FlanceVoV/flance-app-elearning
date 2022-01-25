package com.flance.elearning.tenant.interfaces;

import com.flance.saas.tenant.domain.tenant.domain.entity.Tenant;
import com.flance.saas.tenant.interfaces.tenant.TenantInterface;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tenant")
public class TenantController {

    @Resource
    private TenantInterface tenantInterface;

    public void createNewTenant() {

    }

}
