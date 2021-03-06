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
@Table(tableName = "biz_elearning_answer", indexes = {
        @Index(indexName = "idx_answer_content", columns = {"answer_content"}),
        @Index(indexName = "idx_answer_desc", columns = {"answer_desc"}),
})
@TableName("biz_elearning_answer")
public class Answer extends BaseTable {

    @Column(notNull = true)
    private String answerContent;

    @Column(notNull = true)
    private String answerDesc;

}
