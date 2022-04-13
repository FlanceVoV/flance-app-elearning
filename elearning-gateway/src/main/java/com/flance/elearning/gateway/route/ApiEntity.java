package com.flance.elearning.gateway.route;

import com.flance.web.utils.route.RouteApiModel;
import com.flance.web.utils.route.RouteModel;
import lombok.Data;

@Data
public class ApiEntity implements RouteApiModel {

    private String apiId;

    private String appId;

    private String routeId;

    private String apiName;

    private String apiUri;

    private String apiPath;

    private String apiVersion;

    private String apiFilter;

    private Integer apiLimit;

    private Integer apiTimeOut;

    private RouteEntity routeEntity;

    @Override
    public RouteModel getRouteModel() {
        return this.routeEntity;
    }
}
