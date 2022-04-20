package com.flance.tenant.biz.tables.examination;

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

@Data
@EqualsAndHashCode(callSuper = true)
@Table(tableName = "biz_elearning_test_paper_question", indexes = {
        @Index(indexName = "un_paperId_sort", columns = {"test_paper_id", "sort"}, indexType = Index.IndexType.UNIQUE),
        @Index(indexName = "un_paperId_questionId", columns = {"test_paper_id", "question_id"}, indexType = Index.IndexType.UNIQUE),
})
@TableName("biz_elearning_test_paper_question")
public class TestPaperQuestion extends BaseTable implements TreeModel<TestPaperQuestion, String> {

    @Column(notNull = true)
    private String testPaperId;

    /**
     * 原来的题目
     */
    @Column(notNull = true)
    private String questionId;

    /**
     * 快照-题目标题
     */
    @Column(notNull = true)
    private String questionTitle;

    /**
     * 快照-题目内容
     */
    @Column(notNull = true, length = "4000")
    private String questionContent;

    /**
     * 快照-题目简介
     */
    @Column(notNull = true, length = "2000")
    private String questionDesc;

    /**
     * 快照-题目文件资源路径
     */
    @Column
    private String questionResourceUrl;

    /**
     * 快照-题目类型（如：选择、填空、问答...）
     */
    @Column(notNull = true)
    private String questionType;

    /**
     * 快照-题目业务类型
     */
    @Column
    private String questionBizType;

    /**
     * 快照-题目分类
     */
    @Column
    private String questionClassic;

    /**
     * 快照-父级题目
     */
    @Column(notNull = true)
    private String parentId;

    /**
     * 快照-排序
     */
    @Column
    private Integer sort;

    /**
     * 快照-判题模式0.系统 1.人工
     */
    @Column(notNull = true)
    private Integer reviewType;

    /**
     * 快照-分值
     */
    @Column(notNull = true)
    private Double score;

    /**
     * 子集题目
     */
    @TableField(exist = false)
    private List<TestPaperQuestion> children;

    /**
     * 答案集合
     */
    @TableField(exist = false)
    private List<TestPaperAnswer> answers;

}
