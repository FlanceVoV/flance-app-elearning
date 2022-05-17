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

/**
 * 试卷
 * @author jhf
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_test_paper", indexes = {
        @Index(indexName = "idx_paper_code", columns = {"paper_code"}),
})
@TableName("biz_elearning_test_paper")
public class TestPaper extends BaseTable {

    /**
     * 试卷编号
     */
    @Column(notNull = true)
    private String paperCode;

    /**
     * 所属题库
     */
    @Column(notNull = true)
    private String questionBankId;

    /**
     * 试题
     */
    @TableField(exist = false)
    private List<TestPaperQuestion> questions;

}
