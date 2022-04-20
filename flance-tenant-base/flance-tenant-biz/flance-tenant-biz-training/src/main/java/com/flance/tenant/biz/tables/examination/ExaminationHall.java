package com.flance.tenant.biz.tables.examination;

import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Index;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_examiation_hall", indexes = {
        @Index(indexName = "idx_name", columns = {"name"}),
        @Index(indexName = "un_code", columns = {"code"}, indexType = Index.IndexType.UNIQUE),
})
@TableName("biz_elearning_examiation_hall")
public class ExaminationHall extends BaseTable {

    private String name;

    private String code;

    private List<ExaminationUser> examinationUsers;

}
