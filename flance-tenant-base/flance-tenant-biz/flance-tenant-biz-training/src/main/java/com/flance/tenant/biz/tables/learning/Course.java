package com.flance.tenant.biz.tables.learning;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Column;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 课程
 * @author jhf
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_course", indexes = {

})
@TableName("biz_elearning_course")
public class Course extends BaseTable {

    /**
     * 课程标题
     */
    @Column(notNull = true)
    private String courseTitle;

    /**
     * 课程编码
     */
    @Column(notNull = true)
    private String courseCode;

    /**
     * 课程描述
     */
    @Column(notNull = true)
    private String courseDesc;

    /**
     * 课程名目
     */
    @Column(notNull = true)
    private String subjectClassicId;

    /**
     * 课程热度
     */
    @Column(notNull = true)
    private Integer courseHot;

    @TableField(exist = false)
    private List<CourseUnit> courseUnits;

    @TableField(exist = false)
    private List<CourseFile> courseFiles;

    @TableField(exist = false)
    private List<CourseUser> courseUsers;
}
