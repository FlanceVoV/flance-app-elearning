package com.flance.elearning.gateway.service;

import com.flance.elearning.gateway.route.AppEntity;
import com.flance.web.gateway.client.AppClient;
import com.flance.web.gateway.common.BizConstant;
import com.flance.web.gateway.service.AppService;
import com.flance.web.utils.RedisUtils;
import com.flance.web.utils.route.AppModel;
import com.flance.web.utils.web.response.WebResponse;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class RouteAppService implements AppService {

    @Resource
    RedisUtils redisUtils;

    @Resource
    AppClient appClient;

    @Override
    public List<? extends AppModel> getApps() {
        WebResponse webResponse = appClient.getApps();
        return webResponse.getResultList(AppEntity.class);
    }

    @Override
    public AppModel getAppByAppId(String appId) {
        Gson gson = new Gson();
        String appStr = redisUtils.get(BizConstant.APP_KEY + ":" + appId);
        return gson.fromJson(appStr, AppEntity.class);
    }
}
