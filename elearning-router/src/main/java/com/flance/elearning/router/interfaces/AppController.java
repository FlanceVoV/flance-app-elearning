package com.flance.elearning.router.interfaces;

import com.flance.elearning.router.domain.app.domain.AppDomain;
import com.flance.elearning.router.domain.app.domain.entity.AppEntity;
import com.flance.elearning.router.domain.app.service.AppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {

    @Resource
    AppService appService;


    @GetMapping("/getApps")
    public List<AppEntity> getApps() {
        AppDomain appDomain = AppDomain.builder()
                .appEntity(new AppEntity())
                .appService(appService)
                .build();
        return appDomain.list();
    }



}
