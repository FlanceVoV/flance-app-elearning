package com.flance.app.elearning.interfaces;

import com.flance.app.elearning.service.ExaminationFacadeService;
import com.flance.web.utils.exception.BizException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 考试 接口
 * @author jhf
 */
@RestController
@RequestMapping("/exam")
public class ExamController {

    @Resource
    private ExaminationFacadeService examinationFacadeService;

    @GetMapping("/test")
    public void test() {
//        examinationFacadeService.listExaminationHall();
        throw BizException.getNormal("非法请求", "100001");
    }

}
