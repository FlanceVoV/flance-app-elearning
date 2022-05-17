package com.flance.tenant.biz.tables.question;

import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Column;
import com.flance.saas.db.annotation.Index;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 题库
 * @author jhf
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_question_bank", indexes = {
})
@TableName("biz_elearning_question_bank")
public class QuestionBank extends BaseTable {

    @Column(notNull = true)
    private String questionBankName;

    @Column(notNull = true)
    private String questionBankDesc;

    @Column(notNull = true)
    private String questionBankStars;

    @Column(notNull = true)
    private String subjectClassicId;

    @Column
    private String questionBankType;

    @Column
    private String questionBankBizType;

    @Column
    private Integer questionCounts;

}
