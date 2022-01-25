package com.flance.elearning.gateway.service;

import com.flance.elearning.gateway.client.GatewayRouterClient;

import com.flance.elearning.gateway.route.ApiEntity;
import com.flance.elearning.gateway.route.RouteEntity;
import com.flance.web.gateway.common.BizConstant;
import com.flance.web.gateway.service.RouteService;
import com.flance.web.utils.RedisUtils;
import com.flance.web.utils.route.RouteModel;
import com.flance.web.utils.web.response.WebResponse;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class RouteServiceImpl implements RouteService {

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private GatewayRouterClient routerClient;

    @Override
    public List<? extends RouteModel> getRouteLists() {
        WebResponse webResponse = routerClient.getRouters();
        return webResponse.getResultList(RouteEntity.class);
    }

    @Override
    public RouteDefinition getRouteById(String routeId) {
        Gson gson = new Gson();
        List<RouteDefinition> list = Lists.newArrayList();
        String data = redisUtils.get(BizConstant.ROUTER_KEY);
        if (!StringUtils.isEmpty(data)) {
            JsonArray jsonArray = JsonParser.parseString(data).getAsJsonArray();
            jsonArray.forEach(route -> list.add(gson.fromJson(route, RouteDefinition.class)));
        }
        AtomicReference<RouteDefinition> definition = new AtomicReference<>();
        list.stream().filter(item -> item.getId().equals(routeId)).findFirst().ifPresent(definition::set);
        return definition.get();
    }

    @Override
    public RouteModel getRouteModelById(String routeId) {
        String result = redisUtils.get(BizConstant.ROUTER_MODEL_KEY + ":" + routeId);
        Gson gson = new Gson();
        return null == result ? null : gson.fromJson(result, RouteEntity.class);
    }
}
