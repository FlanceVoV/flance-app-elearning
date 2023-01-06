package com.flance.app.elearning.service.impl;

import com.flance.tenant.biz.common.examination.service.ExaminationService;
import com.flance.app.elearning.service.ExaminationFacadeService;
import com.flance.tenant.biz.common.examination_hall.service.ExaminationHallService;
import com.flance.tenant.biz.tables.examination.ExaminationHall;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 考试业务
 * @author jhf
 */
@Service
public class ExaminationFacadeServiceImpl implements ExaminationFacadeService {

    @Resource
    private ExaminationService examinationService;

    @Resource
    private ExaminationHallService examinationHallService;

    @Override
    public List<ExaminationHall> listExaminationHall() {
        return examinationHallService.list();
    }
}
