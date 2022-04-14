package com.flance.tenant.gateway.route;

import com.flance.web.utils.route.AppModel;
import lombok.Data;

import java.util.List;

/**
 * app模型
 * @author jhf
 */
@Data
public class AppEntity implements AppModel {

    private String appRsaPubKey;

    private String sysRsaPriKey;

    private String sysRsaPubKey;

    private String appName;

    private String appId;

    private Integer enabled;

    private String serverResource;

    private String apiResource;

    private List<String> serverResources;

    private List<String> apiResources;

}
