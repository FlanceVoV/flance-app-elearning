package com.flance.tenant.biz.tables.examination;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Column;
import com.flance.saas.db.annotation.Index;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_test_paper", indexes = {
        @Index(indexName = "idx_paper_code", columns = {"paper_code"}),
})
@TableName("biz_elearning_test_paper")
public class TestPaper extends BaseTable {

    @Column(notNull = true)
    private String paperCode;

    /**
     * 试卷时间限制，单位秒
     */
    @Column(notNull = true)
    private Long timeLimit;

    @TableField(exist = false)
    private List<TestPaperQuestion> questions;

    @TableField(exist = false)
    private List<TestPaperAnswer> answers;

}
