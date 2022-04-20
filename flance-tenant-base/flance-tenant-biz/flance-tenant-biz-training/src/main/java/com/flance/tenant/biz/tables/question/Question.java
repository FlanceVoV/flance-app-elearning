package com.flance.tenant.biz.tables.question;

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
@Table(tableName = "biz_elearning_question", indexes = {
        @Index(indexName = "idx_question_content", columns = {"question_title", "question_content", "question_desc"}),
        @Index(indexName = "idx_question_type", columns = {"question_type"}),
        @Index(indexName = "idx_question_biz_type", columns = {"question_biz_type"}),
})
@TableName("biz_elearning_question")
public class Question extends BaseTable implements TreeModel<Question, String> {

    /**
     * 题目标题
     */
    @Column(notNull = true)
    private String questionTitle;

    /**
     * 题目内容
     */
    @Column(notNull = true, length = "4000")
    private String questionContent;

    /**
     * 题目简介
     */
    @Column(notNull = true, length = "2000")
    private String questionDesc;

    /**
     * 题目文件资源路径
     */
    @Column
    private String questionResourceUrl;

    /**
     * 题目类型（如：选择、填空、问答...）
     */
    @Column(notNull = true)
    private String questionType;

    /**
     * 题目业务类型
     */
    @Column
    private String questionBizType;

    /**
     * 题目分类
     */
    @Column
    private String questionClassic;

    /**
     * 父级题目
     */
    @Column(notNull = true)
    private String parentId;

    /**
     * 排序
     */
    @Column
    private Integer sort;

    /**
     * 判题模式0.系统 1.人工
     */
    @Column(notNull = true)
    private Integer reviewType;

    /**
     * 分值
     */
    @Column(notNull = true)
    private Double score;

    /**
     * 子集题目
     */
    @TableField(exist = false)
    private List<Question> children;

    /**
     * 答案集合
     */
    @TableField(exist = false)
    private List<Answer> answers;
}
