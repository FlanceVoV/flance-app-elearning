package com.flance.elearning.router.domain.router.service.impl;

import com.flance.elearning.router.domain.router.domain.entity.RouteEntity;
import com.flance.elearning.router.domain.router.mapper.RouterMapper;
import com.flance.elearning.router.domain.router.service.RouterService;
import com.flance.jdbc.mybatis.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class RouterServiceImpl extends BaseService<String, RouterMapper, RouteEntity> implements RouterService {
}
