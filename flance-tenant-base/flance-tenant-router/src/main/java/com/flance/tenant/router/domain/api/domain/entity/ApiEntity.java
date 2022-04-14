package com.flance.tenant.router.domain.api.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.tenant.router.domain.router.domain.entity.RouteEntity;
import com.flance.saas.db.annotation.Column;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import com.flance.web.utils.route.RouteApiModel;
import com.flance.web.utils.route.RouteModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_flance_api")
@Table(tableName = "sys_flance_api")
public class ApiEntity extends BaseTable implements RouteApiModel {

    @Column(notNull = true, length = "64")
    private String apiId;

    @Column(notNull = true, length = "64")
    private String appId;

    @Column(notNull = true, length = "64")
    private String routeId;

    @Column(notNull = true, length = "64")
    private String apiName;

    @Column(notNull = true)
    private String apiUri;

    @Column(notNull = true)
    private String apiPath;

    @Column(notNull = true, length = "32")
    private String apiVersion;

    @Column(notNull = true, length = "255")
    private String apiFilter;

    @Column
    private Integer apiLimit;

    @Column
    private Integer apiTimeOut;

    @TableField(exist = false)
    private RouteEntity routeEntity;

    @Override
    public RouteModel getRouteModel() {
        return this.routeEntity;
    }

}
