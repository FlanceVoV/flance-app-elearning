package com.flance.elearning.router.domain.router.domain.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.jdbc.mybatis.common.BaseEntity;
import com.flance.web.utils.route.RouteModel;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_flance_router")
public class RouteEntity extends BaseEntity<String> implements RouteModel {

    private String routeId;

    private String routeName;

    private String routePath;

    private String routeUri;

    private String routeCode;

    private String filter;

    private Integer requestLimit;

    private Integer timeOut;

}
