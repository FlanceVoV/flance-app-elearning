package com.flance.elearning.router.domain.api.service.impl;

import com.flance.elearning.router.domain.api.domain.entity.ApiEntity;
import com.flance.elearning.router.domain.api.mapper.ApiMapper;
import com.flance.elearning.router.domain.api.service.ApiService;
import com.flance.jdbc.mybatis.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ApiServiceImpl extends BaseService<String, ApiMapper, ApiEntity> implements ApiService {


}
