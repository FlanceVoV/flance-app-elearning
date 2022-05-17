package com.flance.tenant.biz.tables.examination;

import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Column;
import com.flance.saas.db.annotation.Index;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 试卷-答案
 * @author jhf
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_test_paper_answer", indexes = {
        @Index(indexName = "idx_test_paper_id", columns = {"test_paper_id"}),
        @Index(indexName = "idx_question_id", columns = {"question_id"}),
        @Index(indexName = "idx_answer_id", columns = {"answer_id"}),
        @Index(indexName = "idx_answer_content", columns = {"answer_content"}),
        @Index(indexName = "idx_answer_desc", columns = {"answer_desc"}),
})
@TableName("biz_elearning_test_paper_answer")
public class TestPaperAnswer extends BaseTable {

    @Column(notNull = true)
    private String testPaperId;

    @Column(notNull = true)
    private String questionId;

    @Column(notNull = true)
    private String answerId;

    @Column(notNull = true)
    private String answerContent;

    @Column(notNull = true)
    private String answerDesc;

}
