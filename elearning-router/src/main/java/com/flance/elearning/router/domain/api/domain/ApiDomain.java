package com.flance.elearning.router.domain.api.domain;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flance.elearning.router.domain.api.domain.entity.ApiEntity;
import com.flance.elearning.router.domain.api.service.ApiService;
import com.flance.web.utils.AssertException;
import com.flance.web.utils.AssertUtil;
import com.flance.web.utils.web.request.PageRequest;
import com.flance.web.utils.web.response.PageResponse;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * api领域模型
 * @author jhf
 */
@Data
@Builder
public class ApiDomain {

    @NonNull
    private ApiEntity apiEntity;

    @NonNull
    private ApiService apiService;

    /**
     * 添加api
     */
    public void create() {
        apiService.save(apiEntity);
    }

    /**
     * 修改
     */
    public void updateById() {
        AssertUtil.notEmpty(apiEntity.getId(), AssertException.getNormal("唯一标识条件[id]不允许为空", "-1"));
        apiService.updateById(apiEntity);
    }

    /**
     * 删除
     */
    public void deleteById() {
        AssertUtil.notEmpty(apiEntity.getId(), AssertException.getNormal("唯一标识条件[id]不允许为空", "-1"));
        ApiEntity waitDelete = new ApiEntity();
        waitDelete.setId(apiEntity.getApiId());
        waitDelete.setStatus(1);
        apiService.updateById(waitDelete);
    }

    /**
     * 根据查询列表
     * @return  返回集合
     */
    public List<ApiEntity> list() {
        return apiService.list(buildDefault(apiEntity));
    }


    /**
     * 分页查询
     * @return  分页封装
     */
    public PageResponse<ApiEntity> page(PageRequest<ApiEntity> pageRequest) {
        Page<ApiEntity> page = new Page();
        page.setSize(pageRequest.getPageSize().longValue());
        page.setPages(pageRequest.getPage().longValue());
        this.apiEntity = pageRequest.getRequestData();
        page = apiService.page(page, buildDefault(apiEntity));
        return new PageResponse<>(page.getTotal(), page.getRecords());
    }


    private LambdaQueryWrapper<ApiEntity> buildDefault(ApiEntity apiEntity) {
        LambdaQueryWrapper<ApiEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ApiEntity::getStatus, 1);
        lambdaQueryWrapper.eq(!StringUtils.isEmpty(apiEntity.getApiName()),ApiEntity::getApiName, apiEntity.getApiName());
        lambdaQueryWrapper.eq(!StringUtils.isEmpty(apiEntity.getApiId()),ApiEntity::getApiName, apiEntity.getApiId());
        lambdaQueryWrapper.eq(!StringUtils.isEmpty(apiEntity.getRouteId()),ApiEntity::getApiName, apiEntity.getRouteId());
        lambdaQueryWrapper.orderByAsc(ApiEntity::getCreateDate);
        return lambdaQueryWrapper;
    }

}
