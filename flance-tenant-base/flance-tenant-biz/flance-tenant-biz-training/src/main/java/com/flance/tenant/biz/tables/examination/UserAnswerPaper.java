package com.flance.tenant.biz.tables.examination;


import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Index;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    private String sort;

    private String testPaperId;

    private String userPaperId;

    private String questionId;

    private String paperQuestionId;

    private String answerContent;

    private Integer isCorrect;

    private Double score;

}
