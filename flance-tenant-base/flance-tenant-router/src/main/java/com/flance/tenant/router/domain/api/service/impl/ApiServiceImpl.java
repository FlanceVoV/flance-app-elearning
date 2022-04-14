package com.flance.tenant.router.domain.api.service.impl;

import com.flance.tenant.router.domain.api.domain.entity.ApiEntity;
import com.flance.tenant.router.domain.api.mapper.ApiMapper;
import com.flance.tenant.router.domain.api.service.ApiService;
import com.flance.tenant.router.domain.router.domain.RouteDomain;
import com.flance.tenant.router.domain.router.domain.entity.RouteEntity;
import com.flance.tenant.router.domain.router.service.RouterService;
import com.flance.jdbc.mybatis.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ApiServiceImpl extends BaseService<String, ApiMapper, ApiEntity> implements ApiService {

    @Resource
    private RouterService routerService;

    @Override
    public void setRouteModel(ApiEntity apiEntity) {
        RouteEntity routeEntity = new RouteEntity();
        routeEntity.setRouteId(apiEntity.getRouteId());
        RouteDomain routeDomain = RouteDomain.builder()
                .routerService(routerService)
                .routeEntity(routeEntity)
                .build();
        apiEntity.setRouteEntity(routeDomain.getByRouteId());
    }
}
