package com.flance.tenant.biz.tables.learning;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Column;
import com.flance.saas.db.annotation.Index;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 课时
 * @author jhf
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_course_unit", indexes = {
        @Index(indexName = "idx_course_id", columns = {"course_id"}),
        @Index(indexName = "idx_sort", columns = {"sort"}),
        @Index(indexName = "idx_course_unit_title", columns = {"course_unit_title"}),
        @Index(indexName = "udx_course_unit_code", columns = {"course_unit_code"}, indexType = Index.IndexType.UNIQUE),
})
@TableName("biz_elearning_course_unit")
public class CourseUnit extends BaseTable {

    /**
     * 课程id
     */
    @Column(notNull = true)
    private String courseId;

    /**
     * 课时序号
     */
    @Column(notNull = true)
    private Integer sort;

    /**
     * 课时编码
     */
    @Column(notNull = true)
    private String courseUnitCode;

    /**
     * 课时标题
     */
    @Column(notNull = true)
    private String courseUnitTitle;

    /**
     * 课时描述
     */
    @Column(notNull = true, length = "1000")
    private String courseUnitDesc;

    /**
     * 课时附件
     */
    @TableField(exist = false)
    private List<CourseFile> courseUnitFiles;

}
