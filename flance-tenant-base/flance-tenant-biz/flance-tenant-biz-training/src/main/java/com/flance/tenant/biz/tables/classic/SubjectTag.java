package com.flance.tenant.biz.tables.classic;

import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Index;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_subject_tag", indexes = {

})
@TableName("biz_elearning_subject_tag")
public class SubjectTag extends BaseTable {



}
