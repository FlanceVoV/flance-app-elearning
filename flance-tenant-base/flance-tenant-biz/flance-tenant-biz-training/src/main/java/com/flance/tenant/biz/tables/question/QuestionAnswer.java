package com.flance.tenant.biz.tables.question;

import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Column;
import com.flance.saas.db.annotation.Index;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_question_answer", indexes = {
        @Index(indexName = "un_question_answer", columns = {"question_id", "answer_id"}, indexType = Index.IndexType.UNIQUE),

})
@TableName("biz_elearning_question_answer")
public class QuestionAnswer extends BaseTable {

    @Column(notNull = true)
    private String questionId;

    @Column(notNull = true)
    private String answerId;

}
