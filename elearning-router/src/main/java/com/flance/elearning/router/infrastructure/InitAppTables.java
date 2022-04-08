package com.flance.elearning.router.infrastructure;

import com.flance.saas.db.interfaces.TableInterface;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class InitAppTables {

    @Resource
    TableInterface tableInterface;

    @PostConstruct
    public void initAppTables() {
        tableInterface.initSelfTable("com.flance.elearning.router");
    }

}
