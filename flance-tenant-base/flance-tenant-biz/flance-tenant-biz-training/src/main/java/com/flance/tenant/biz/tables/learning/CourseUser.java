package com.flance.tenant.biz.tables.learning;

import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Index;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 课程-学生
 * @author jhf
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_course_user", indexes = {
        @Index(indexName = "idx_course_id", columns = {"course_id"}),
        @Index(indexName = "idx_sort", columns = {"sort"}),
})
@TableName("biz_elearning_course_user")
public class CourseUser extends BaseTable {

    private String userId;

    private String courseId;

    private String userName;

    private String courseProgress;

    private Integer isFinished;

}
