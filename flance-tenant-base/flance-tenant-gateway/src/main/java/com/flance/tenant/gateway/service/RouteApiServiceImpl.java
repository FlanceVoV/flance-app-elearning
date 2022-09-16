package com.flance.tenant.gateway.service;

import com.flance.tenant.gateway.client.GatewayRouterApiClient;
import com.flance.tenant.gateway.route.ApiEntity;
import com.flance.web.gateway.common.BizConstant;
import com.flance.web.gateway.service.RouteApiService;
import com.flance.web.utils.RedisUtils;
import com.flance.web.utils.route.RouteApiModel;
import com.flance.web.utils.web.response.WebResponse;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RouteApiServiceImpl implements RouteApiService {

    @Resource
    private GatewayRouterApiClient gatewayRouterApiClient;

    @Resource
    private RedisUtils redisUtils;

    @Override
    public List<? extends RouteApiModel> getAllApi() {
        WebResponse webResponse = gatewayRouterApiClient.getApis();
        return webResponse.getResultList(ApiEntity.class);
    }

    @Override
    public RouteApiModel getOneByApiIdAndVersion(String apiId, String version) {
        if (!StringUtils.hasLength(version)) {
            version = BizConstant.API_VERSION_DEFAULT;
        }
        String result = redisUtils.get(BizConstant.API_KEY + ":" + apiId + ":" + version);
        Gson gson = new Gson();
        return null == result ? null : gson.fromJson(result, RouteApiModel.class);
    }
}
