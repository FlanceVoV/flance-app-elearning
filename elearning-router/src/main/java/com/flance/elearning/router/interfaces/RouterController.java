package com.flance.elearning.router.interfaces;

import com.flance.elearning.router.domain.router.domain.RouteDomain;
import com.flance.elearning.router.domain.router.domain.entity.RouteEntity;
import com.flance.elearning.router.domain.router.service.RouterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 路由加载类
 * @author jhf
 */
@RestController
@RequestMapping("/router")
public class RouterController {

    @Resource
    private RouterService routerService;

    @GetMapping("/getRouters")
    public List<RouteEntity> list() {
        RouteDomain routeDomain = RouteDomain.builder()
                .routerService(routerService)
                .routeEntity(new RouteEntity())
                .build();
        return routeDomain.list();
    }

}
