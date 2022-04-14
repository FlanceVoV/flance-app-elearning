package com.flance.tenant.router.interfaces;

import com.flance.tenant.router.domain.router.domain.RouteDomain;
import com.flance.tenant.router.domain.router.domain.entity.RouteEntity;
import com.flance.tenant.router.domain.router.service.RouterService;
import com.flance.web.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 路由加载类
 * @author jhf
 */
@Slf4j
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

    @PostMapping("/test")
    public List<RouteEntity> test(@RequestBody RouteEntity routeEntity) {
        log.info("请求入参{}", GsonUtils.toJSONString(routeEntity));
        RouteDomain routeDomain = RouteDomain.builder()
                .routerService(routerService)
                .routeEntity(new RouteEntity())
                .build();
        return routeDomain.list();
    }

}
