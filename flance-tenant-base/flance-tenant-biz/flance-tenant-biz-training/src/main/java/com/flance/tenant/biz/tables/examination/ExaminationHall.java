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
        @Index(indexName = "un_code", columns = {"code"}, indexType = Index.IndexType.UNIQUE),
})
@TableName("biz_elearning_examination_hall")
public class ExaminationHall extends BaseTable {

    @Column(notNull = true)
    private String name;

    @Column(notNull = true)
    private String code;

    @Column(notNull = true, length = "1000")
    private String examinationHallDesc;

    @TableField(exist = false)
    private List<ExaminationUser> examinationUsers;

}
