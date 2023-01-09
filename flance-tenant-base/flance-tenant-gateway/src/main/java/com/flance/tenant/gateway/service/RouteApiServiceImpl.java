package com.flance.tenant.gateway.service;

import com.flance.tenant.gateway.client.GatewayRouterApiClient;
import com.flance.tenant.gateway.route.ApiEntity;
import com.flance.tenant.gateway.route.RouteEntity;
import com.flance.web.gateway.common.BizConstant;
import com.flance.web.gateway.service.RouteApiService;
import com.flance.web.utils.RedisUtils;
import com.flance.web.utils.route.AppApiLimitModel;
import com.flance.web.utils.route.RouteApiModel;
import com.flance.web.utils.web.response.WebResponse;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Service
public class RouteApiServiceImpl implements RouteApiService {

    @Resource
    private GatewayRouterApiClient gatewayRouterApiClient;

    @Resource
    private RedisUtils redisUtils;

    @Override
    public List<? extends RouteApiModel> getAllApi(boolean async) {
        if (async) {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future<WebResponse> future = executorService.submit(() -> gatewayRouterApiClient.getApis());
            List<? extends RouteApiModel> list = Lists.newArrayList();
            try {
                list = future.get(1500L, TimeUnit.MILLISECONDS).getResultList(ApiEntity.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            executorService.shutdown();
            return list;
        } else {
            WebResponse webResponse = gatewayRouterApiClient.getApis();
            return webResponse.getResultList(ApiEntity.class);
        }
    }

    @Override
    public RouteApiModel getOneByApiIdAndVersion(String apiId, String version) {
        if (!StringUtils.hasLength(version)) {
            version = BizConstant.API_VERSION_DEFAULT;
        }
        String result = redisUtils.get(BizConstant.API_KEY + ":" + apiId + ":" + version);
        Gson gson = new Gson();
        return null == result ? null : gson.fromJson(result, ApiEntity.class);
    }

    @Override
    public AppApiLimitModel getOneByAppIdAndApiId(String appId, String apiId) {
        return null;
    }
}
