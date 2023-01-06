package com.flance.tenant.biz.common.examination_hall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flance.tenant.biz.common.examination_hall.mapper.ExaminationHallMapper;
import com.flance.tenant.biz.common.examination_hall.service.ExaminationHallService;
import com.flance.tenant.biz.tables.examination.ExaminationHall;
import org.springframework.stereotype.Service;

@Service
public class ExaminationHallServiceImpl extends ServiceImpl<ExaminationHallMapper, ExaminationHall> implements ExaminationHallService {
}
