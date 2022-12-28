package com.flance.tenant.router.interfaces;

import com.alibaba.nacos.api.naming.pojo.Instance;
import com.flance.web.nacos.NacosController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/server")
public class ServerController {

    @Resource
    NacosController nacosController;

    @GetMapping("/getAllInstance")
    public List<Instance> getAllInstance() {
        return nacosController.getAllInstance();
    }

    @GetMapping("/offline")
    public void offline() {
        nacosController.offline();
    }

}
