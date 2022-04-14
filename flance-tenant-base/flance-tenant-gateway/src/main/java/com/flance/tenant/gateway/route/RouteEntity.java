package com.flance.tenant.gateway.route;

import com.flance.web.utils.route.RouteModel;
import lombok.Data;

@Data
public class RouteEntity implements RouteModel {

    private String routeId;

    private String routeName;

    private String routePath;

    private String routeUri;

    private String routeCode;

    private String filter;

    private Integer requestLimit;

    private Integer timeOut;

}
