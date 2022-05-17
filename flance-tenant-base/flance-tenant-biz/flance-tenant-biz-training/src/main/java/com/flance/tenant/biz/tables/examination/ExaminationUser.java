package com.flance.tenant.biz.tables.examination;

import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Column;
import com.flance.saas.db.annotation.Index;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 考试用户
 * @author jhf
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_examination_user", indexes = {
        @Index(indexName = "idx_user_id", columns = {"user_id"}),
        @Index(indexName = "idx_examination_id", columns = {"examination_id"}),
        @Index(indexName = "idx_examination_hall_id", columns = {"examination_hall_id"}),
        @Index(indexName = "idx_user_test_paper_id", columns = {"user_test_paper_id"}),
        @Index(indexName = "idx_start_time", columns = {"start_time"}),
        @Index(indexName = "idx_end_time", columns = {"end_time"}),
        @Index(indexName = "idx_is_pass", columns = {"is_pass"}),
})
@TableName("biz_elearning_examination_user")
public class ExaminationUser extends BaseTable {

    /**
     * 考生 - 考试用户id
     */
    @Column(notNull = true)
    private String userId;

    /**
     * 考试id
     */
    @Column(notNull = true)
    private String examinationId;

    /**
     * 考生所属考场
     */
    @Column(notNull = true)
    private String examinationHallId;

    /**
     * 考生的试卷
     */
    @Column(notNull = true)
    private String userTestPaperId;

    /**
     * 实际开始时间
     */
    @Column(notNull = true)
    private Date startTime;

    /**
     * 要求结束时间
     */
    @Column(notNull = true)
    private Date endTime;

    /**
     * 实际结束时间
     */
    @Column
    private Date actualEndTime;

    /**
     * 扩充结束时间
     */
    @Column
    private Date expandEndTime;

    /**
     * 是否考完
     */
    @Column(notNull = true)
    private Integer isEnd;

    /**
     * 考试分数
     */
    @Column
    private Double score;

    /**
     * 是否通过
     */
    @Column
    private Integer isPass;
}
