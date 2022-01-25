package com.flance.elearning.router.domain.app.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.jdbc.mybatis.common.BaseEntity;
import com.flance.web.utils.route.AppModel;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * app模型
 * @author jhf
 */
@Data
@TableName("sys_flance_app")
@EqualsAndHashCode(callSuper = true)
public class AppEntity  extends BaseEntity<String> implements AppModel {

    private String appRsaPubKey;

    private String sysRsaPriKey;

    private String sysRsaPubKey;

    private String appName;

    private String appId;

    private Integer enabled;

    private String serverResource;

    private String apiResource;

    @TableField(exist = false)
    private List<String> serverResources;

    @TableField(exist = false)
    private List<String> apiResources;

    @Override
    public List<String> getServerResources() {
        return serverResource == null ? null : Lists.newArrayList(serverResource.split(","));
    }

    @Override
    public List<String> getApiResources() {
        return apiResource == null ? null : Lists.newArrayList(apiResource.split(","));
    }

}
