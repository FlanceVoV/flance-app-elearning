package com.flance.elearning.router.interfaces;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.flance.elearning.router.domain.api.domain.ApiDomain;
import com.flance.elearning.router.domain.api.domain.entity.ApiEntity;
import com.flance.elearning.router.domain.api.service.ApiService;
import com.flance.elearning.router.domain.router.domain.RouteDomain;
import com.flance.elearning.router.domain.router.domain.entity.RouteEntity;
import com.flance.elearning.router.domain.router.service.RouterService;
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

        List<ApiEntity> list = apiDomain.list();
        list.forEach(api -> {
            RouteEntity routeEntity = new RouteEntity();
            routeEntity.setRouteId(api.getRouteId());
            RouteDomain routeDomain = RouteDomain.builder()
                    .routeEntity(routeEntity)
                    .routerService(routerService)
                    .build();
            api.setRouteEntity(routeDomain.getByRouteId());
        });
        return list;
    }

}
