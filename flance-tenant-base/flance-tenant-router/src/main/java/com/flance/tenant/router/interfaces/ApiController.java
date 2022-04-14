package com.flance.tenant.router.interfaces;

import com.flance.tenant.router.domain.api.domain.ApiDomain;
import com.flance.tenant.router.domain.api.domain.entity.ApiEntity;
import com.flance.tenant.router.domain.api.service.ApiService;
import com.flance.tenant.router.domain.router.service.RouterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Resource
    ApiService apiService;

    @Resource
    RouterService routerService;

    @GetMapping("/getApis")
    public List<ApiEntity> getAllApis() {
        ApiDomain apiDomain = ApiDomain.builder()
                .apiService(apiService)
                .apiEntity(new ApiEntity())
                .build();

        return apiDomain.list();
    }

}
