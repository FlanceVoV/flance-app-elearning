package com.flance.elearning.router.domain.router.domain.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.jdbc.mybatis.common.BaseEntity;
import com.flance.saas.db.annotation.Column;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import com.flance.web.utils.route.RouteModel;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_flance_router")
@Table(tableName = "sys_flance_router")
public class RouteEntity extends BaseTable implements RouteModel {

    @Column(notNull = true, length = "64")
    private String routeId;

    @Column(notNull = true)
    private String routeName;

    @Column(notNull = true)
    private String routePath;

    @Column(notNull = true)
    private String routeUri;

    @Column(notNull = true)
    private String routeCode;

    @Column
    private String filter;

    @Column
    private Integer requestLimit;

    @Column
    private Integer timeOut;

}
