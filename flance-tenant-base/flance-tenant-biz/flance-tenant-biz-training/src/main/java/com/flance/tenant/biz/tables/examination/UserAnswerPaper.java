package com.flance.tenant.biz.tables.examination;


import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Column;
import com.flance.saas.db.annotation.Index;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户答题卡-项目
 * @author jfh
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_user_answer_paper", indexes = {
        @Index(indexName = "un_paper", columns = {"test_paper_id", "user_paper_id"}, indexType = Index.IndexType.UNIQUE),
        @Index(indexName = "un_question", columns = {"test_paper_id", "paper_question_id"}, indexType = Index.IndexType.UNIQUE),
        @Index(indexName = "idx_sort", columns = {"sort"}),
        @Index(indexName = "idx_test_paper_id", columns = {"test_paper_id"}),
        @Index(indexName = "idx_user_paper_id", columns = {"user_paper_id"}),
        @Index(indexName = "idx_question_id", columns = {"question_id"}),
        @Index(indexName = "idx_paper_question_id", columns = {"paper_question_id"}),
        @Index(indexName = "idx_answer_content", columns = {"answer_content"}),
        @Index(indexName = "idx_is_correct", columns = {"is_correct"}),
})
@TableName("biz_elearning_user_answer_paper")
public class UserAnswerPaper extends BaseTable {

    @Column(notNull = true)
    private String sort;

    @Column(notNull = true)
    private String testPaperId;

    @Column(notNull = true)
    private String userPaperId;

    @Column(notNull = true)
    private String questionId;

    @Column(notNull = true)
    private String paperQuestionId;

    @Column
    private String answerContent;

    @Column
    private Integer isCorrect;

    @Column
    private Double score;

}
