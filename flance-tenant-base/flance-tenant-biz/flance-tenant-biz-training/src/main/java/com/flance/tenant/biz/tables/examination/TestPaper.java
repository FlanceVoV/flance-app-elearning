package com.flance.tenant.biz.tables.examination;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.List;

public class TestPaper {

    private String paperCode;

    @TableField(exist = false)
    private List<TestPaperQuestion> questions;

}
