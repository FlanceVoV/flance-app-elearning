package com.flance.elearning.router.domain.app.domain;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.flance.elearning.router.domain.app.domain.entity.AppEntity;
import com.flance.elearning.router.domain.app.service.AppService;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class AppDomain {

    @NonNull
    private AppEntity appEntity;

    @NonNull
    private AppService appService;

    public List<AppEntity> list() {
        LambdaQueryWrapper<AppEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(AppEntity::getStatus, 1);
        return appService.list(lambdaQueryWrapper);
    }

}
