package com.flance.tenant.biz.tables.classic;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flance.saas.db.annotation.Column;
import com.flance.saas.db.annotation.Index;
import com.flance.saas.db.annotation.Table;
import com.flance.saas.db.tables.common.BaseTable;
import com.flance.web.utils.TreeModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 名目
 * @author jhf
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_subject_classic", indexes = {
        @Index(columns = {"classic_code"}, indexName = "udx_classic_code", indexType = Index.IndexType.UNIQUE),
        @Index(columns = {"classic_name"}, indexName = "idx_classic_name"),
        @Index(columns = {"parent_id"}, indexName = "idx_parent_id"),
        @Index(columns = {"sort"}, indexName = "idx_sort"),
})
@TableName("biz_elearning_subject_classic")
public class SubjectClassic extends BaseTable implements TreeModel<SubjectClassic, String> {

    @Column(notNull = true)
    private String classicName;

    @Column(notNull = true)
    private String classicCode;

    @Column(notNull = true)
    private Integer sort;

    @Column(notNull = true)
    private String parentId;

    @TableField(exist = false)
    private List<SubjectClassic> children;

}
