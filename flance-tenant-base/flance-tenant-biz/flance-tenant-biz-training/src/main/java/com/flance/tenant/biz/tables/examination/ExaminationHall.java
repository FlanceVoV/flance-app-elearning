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

/**
 * 考场
 * @author jhf
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_examination_hall", indexes = {
        @Index(indexName = "idx_name", columns = {"name"}),
        @Index(indexName = "idx_examination_id", columns = {"examination_id"}),
        @Index(indexName = "un_code", columns = {"code"}, indexType = Index.IndexType.UNIQUE),
})
@TableName("biz_elearning_examination_hall")
public class ExaminationHall extends BaseTable {

    /**
     * 考场名称
     */
    @Column(notNull = true)
    private String name;

    /**
     * 考场代码
     */
    @Column(notNull = true)
    private String code;

    /**
     * 所属考试id
     */
    @Column(notNull = true)
    private String examinationId;

    /**
     * 考场说明
     */
    @Column(notNull = true, length = "1000")
    private String examinationHallDesc;

    /**
     * 考场的考生
     */
    @TableField(exist = false)
    private List<ExaminationUser> examinationUsers;

}
