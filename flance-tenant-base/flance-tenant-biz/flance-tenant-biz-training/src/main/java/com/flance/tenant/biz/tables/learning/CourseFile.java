package com.flance.tenant.biz.tables.learning;

import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Column;
import com.flance.saas.db.annotation.Index;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 课程文件
 * @author jhf
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_course_file", indexes = {
        @Index(indexName = "idx_course_id", columns = {"course_id"}),
        @Index(indexName = "idx_course_unit_id", columns = {"course_unit_id"}),
        @Index(indexName = "idx_sort", columns = {"sort"}),
        @Index(indexName = "idx_file_type", columns = {"file_type"}),
        @Index(indexName = "idx_file_exp_type", columns = {"file_exp_type"}),
        @Index(indexName = "idx_file_name", columns = {"file_name"}),
        @Index(indexName = "idx_file_id", columns = {"file_id"}),
})
@TableName("biz_elearning_course_file")
public class CourseFile extends BaseTable {

    /**
     * 排序
     */
    @Column(notNull = true)
    private Integer sort;

    /**
     * 课程id
     */
    @Column(notNull = true)
    private String courseId;

    /**
     * 课时id
     */
    @Column
    private String courseUnitId;

    /**
     * 1. pdf
     * 2. mp4
     * 3. mp3
     * ...
     */
    @Column(notNull = true)
    private String fileType;

    /**
     * 文件后缀类型
     */
    @Column(notNull = true)
    private String fileExpType;

    /**
     * 业务文件名
     */
    @Column(notNull = true)
    private String fileName;

    /**
     * 文件大小MB
     */
    @Column(notNull = true)
    private String fileSize;

    /**
     * 文件服务返回的唯一标识
     */
    @Column(notNull = true)
    private String fileId;

    /**
     * cdn加速url
     */
    @Column(notNull = true, length = "500")
    private String fileUrl;
}
