package com.flance.tenant.biz.tables.examination;

import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Index;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_examiation_user", indexes = {
        @Index(indexName = "idx_user_id", columns = {"user_id"}),
        @Index(indexName = "idx_examiation_id", columns = {"examiation_id"}),
        @Index(indexName = "idx_examiation_hall_id", columns = {"examiation_hall_id"}),
        @Index(indexName = "idx_user_test_paper_id", columns = {"user_test_paper_id"}),
        @Index(indexName = "idx_start_time", columns = {"start_time"}),
        @Index(indexName = "idx_end_time", columns = {"end_time"}),
        @Index(indexName = "idx_is_pass", columns = {"is_pass"}),
})
@TableName("biz_elearning_examiation_user")
public class ExaminationUser extends BaseTable {

    private String userId;

    private String examinationId;

    private String examinationHallId;

    private String userTestPaperId;

    /**
     * 实际开始时间
     */
    private Date startTime;

    /**
     * 实际结束时间
     */
    private Date endTime;

    /**
     * 扩充结束时间
     */
    private Date expandEndTime;

    /**
     * 是否考完
     */
    private Integer isEnd;

    /**
     * 考试分数
     */
    private Double score;

    /**
     * 是否通过
     */
    private Integer isPass;
}
