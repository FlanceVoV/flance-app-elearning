package com.flance.tenant.biz.tables.examination;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Column;
import com.flance.saas.db.annotation.Index;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * 考试
 * @author jhf
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_examination", indexes = {
        @Index(indexName = "idx_examination_title", columns = {"examination_title"}),
        @Index(indexName = "idx_start_time", columns = {"start_time"}),
        @Index(indexName = "idx_end_time", columns = {"end_time"}),
        @Index(indexName = "idx_examination_date", columns = {"examination_date"}),
})
@TableName("biz_elearning_examination")
public class Examination extends BaseTable {

    /**
     * 考试标题
     */
    @Column(notNull = true)
    private String examinationTitle;

    /**
     * 考试描述
     */
    @Column(notNull = true, length = "1000")
    private String examinationDesc;

    /**
     * 考试日期、年度-月份
     */
    @Column(notNull = true)
    private String examinationDate;

    /**
     * 考试开始时间
     */
    @Column(notNull = true)
    private Date startTime;

    /**
     * 考试结束时间
     */
    @Column(notNull = true)
    private Date endTime;

    /**
     * 考试所属学科、名目
     */
    @Column(notNull = true)
    private String subjectClassicId;

    /**
     * 考试包含的考场
     */
    @TableField(exist = false)
    private List<ExaminationHall> examinationHalls;

    /**
     * 所有考生
     */
    @TableField(exist = false)
    private List<ExaminationUser> examinationUsers;

}
