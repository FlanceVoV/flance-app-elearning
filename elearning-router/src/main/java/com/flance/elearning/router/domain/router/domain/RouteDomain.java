package com.flance.elearning.router.domain.router.domain;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.flance.elearning.router.domain.router.domain.entity.RouteEntity;
import com.flance.elearning.router.domain.router.service.RouterService;
import com.flance.web.utils.AssertException;
import com.flance.web.utils.AssertUtil;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 服务路由领域
 * @author jhf
 */
@Data
@Builder
public class RouteDomain {

    @NonNull
    private RouteEntity routeEntity;

    @NonNull
    private RouterService routerService;

    /**
     * 根据路由唯一标识（非主键查询）
     * @return  路由实例
     */
    public RouteEntity getByRouteId() {
        AssertUtil.notEmpty(routeEntity.getRouteId(), AssertException.getNormal("唯一标识条件[id]不允许为空", "-1"));
        LambdaQueryWrapper<RouteEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(RouteEntity::getStatus, 1);
        lambdaQueryWrapper.eq(RouteEntity::getRouteId, routeEntity.getRouteId());
        return routerService.getOne(lambdaQueryWrapper);
    }

    /**
     * 根据条件查询
     * @return  返回集合
     */
    public List<RouteEntity> list() {
        LambdaQueryWrapper<RouteEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(RouteEntity::getStatus, 1);
        lambdaQueryWrapper.eq(!StringUtils.isEmpty(routeEntity.getRouteName()), RouteEntity::getRouteName, routeEntity.getRouteName());
        lambdaQueryWrapper.orderByDesc(RouteEntity::getCreateDate);
        return routerService.list();
    }

}
