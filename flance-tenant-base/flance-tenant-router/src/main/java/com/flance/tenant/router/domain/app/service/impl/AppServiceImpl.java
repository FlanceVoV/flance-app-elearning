package com.flance.tenant.router.domain.app.service.impl;

import com.flance.tenant.router.domain.app.domain.entity.AppEntity;
import com.flance.tenant.router.domain.app.mapper.AppMapper;
import com.flance.tenant.router.domain.app.service.AppService;
import com.flance.jdbc.mybatis.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl extends BaseService<String, AppMapper, AppEntity> implements AppService {



}
