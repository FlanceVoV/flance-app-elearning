package com.flance.tenant.router.domain.app.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.jdbc.mybatis.common.BaseEntity;
import com.flance.saas.db.annotation.Column;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
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
@Table(tableName = "sys_flance_app")
@EqualsAndHashCode(callSuper = true)
public class AppEntity  extends BaseTable implements AppModel {

    @Column(length = "500")
    private String appRsaPubKey;

    @Column(length = "2000")
    private String sysRsaPriKey;

    @Column(length = "500")
    private String sysRsaPubKey;

    @Column(length = "64")
    private String appName;

    @Column(length = "64")
    private String appId;

    @Column
    private Integer enabled;

    @Column(length = "2000")
    private String serverResource;

    @Column(length = "2000")
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
