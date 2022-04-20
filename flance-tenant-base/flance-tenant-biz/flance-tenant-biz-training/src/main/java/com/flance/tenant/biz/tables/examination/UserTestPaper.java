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
@Table(tableName = "biz_elearning_user_test_paper", indexes = {
        @Index(indexName = "un_user_paper", columns = {"user_id", "test_paper_id"}, indexType = Index.IndexType.UNIQUE),
})
@TableName("biz_elearning_user_test_paper")
public class UserTestPaper extends BaseTable {

    @Column(notNull = true)
    private String userId;

    @Column(notNull = true)
    private String testPaperId;

    @TableField(exist = false)
    private List<UserAnswerPaper> userAnswerPapers;

}
