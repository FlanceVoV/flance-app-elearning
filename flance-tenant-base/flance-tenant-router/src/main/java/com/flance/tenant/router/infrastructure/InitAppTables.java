package com.flance.tenant.router.infrastructure;

import com.flance.saas.db.interfaces.TableInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class InitAppTables {

    @Resource
    TableInterface tableInterface;

    @Value("${flance.saas.app.init}")
    Boolean initAppTable;

    @PostConstruct
    public void initAppTables() {
        if (initAppTable) {
            tableInterface.initSelfTable("com.flance.tenant.router");
        }
    }

}
