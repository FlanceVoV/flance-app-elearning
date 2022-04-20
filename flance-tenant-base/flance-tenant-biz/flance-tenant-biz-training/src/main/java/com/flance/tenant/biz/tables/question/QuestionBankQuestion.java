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
@Table(tableName = "biz_elearning_question_bank_question", indexes = {
        @Index(indexName = "idx_question_id", columns = {"question_id"}),
        @Index(indexName = "idx_question_bank_id", columns = {"question_bank_id"}),
        @Index(indexName = "idx_sort", columns = {"sort"}),
})
@TableName("biz_elearning_question_bank_question")
public class QuestionBankQuestion extends BaseTable {

    @Column(notNull = true)
    private String questionId;

    @Column(notNull = true)
    private String questionBankId;

    @Column(notNull = true)
    private Integer sort;

}
