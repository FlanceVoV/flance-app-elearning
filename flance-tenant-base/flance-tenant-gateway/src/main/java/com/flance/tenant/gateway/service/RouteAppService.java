package com.flance.tenant.gateway.service;

import com.flance.tenant.gateway.route.AppEntity;
import com.flance.web.gateway.client.AppClient;
import com.flance.web.gateway.common.BizConstant;
import com.flance.web.gateway.service.AppService;
import com.flance.web.utils.RedisUtils;
import com.flance.web.utils.route.AppModel;
import com.flance.web.utils.web.response.WebResponse;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.*;


@Service
public class RouteAppService implements AppService {

    @Resource
    RedisUtils redisUtils;

    @Resource
    AppClient appClient;

    @Override
    public List<? extends AppModel> getApps(boolean async) {
        if (async) {
            ExecutorService executorService = Executors.newScheduledThreadPool(6);
            Future<WebResponse> future = executorService.submit(() -> appClient.getApps());
            List<? extends AppModel> list = Lists.newArrayList();
            try {
                list = future.get(500L, TimeUnit.MILLISECONDS).getResultList(AppEntity.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            executorService.shutdown();
            return list;
        } else {
            WebResponse webResponse = appClient.getApps();
            return webResponse.getResultList(AppEntity.class);
        }

    }

    @Override
    public AppModel getAppByAppId(String appId) {
        Gson gson = new Gson();
        String appStr = redisUtils.get(BizConstant.APP_KEY + ":" + appId);
        return gson.fromJson(appStr, AppEntity.class);
    }
}
