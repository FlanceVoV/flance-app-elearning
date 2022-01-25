package com.flance.elearning.router.domain.api.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.elearning.router.domain.router.domain.entity.RouteEntity;
import com.flance.jdbc.mybatis.common.BaseEntity;
import com.flance.web.utils.route.RouteApiModel;
import com.flance.web.utils.route.RouteModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_flance_api")
public class ApiEntity extends BaseEntity<String> implements RouteApiModel {

    private String apiId;

    private String routeId;

    private String apiName;

    private String apiUri;

    private String apiPath;

    private String apiVersion;

    private String apiFilter;

    private Integer apiLimit;

    private Integer apiTimeOut;

    @TableField(exist = false)
    private RouteEntity routeEntity;

    @Override
    public RouteModel getRouteModel() {
        return this.routeEntity;
    }

}
