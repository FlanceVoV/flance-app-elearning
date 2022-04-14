package com.flance.tenant.router.domain.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.flance.tenant.router.domain.api.domain.entity.ApiEntity;

public interface ApiService extends IService<ApiEntity> {

    void setRouteModel(ApiEntity apiEntity);

}
