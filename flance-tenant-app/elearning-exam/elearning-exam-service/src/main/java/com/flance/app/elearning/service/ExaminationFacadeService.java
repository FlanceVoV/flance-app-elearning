package com.flance.app.elearning.service;

import com.flance.tenant.biz.tables.examination.ExaminationHall;

import java.util.List;

/**
 * 考试业务
 * @author jhf
 */
public interface ExaminationFacadeService {

    List<ExaminationHall> listExaminationHall();

}
