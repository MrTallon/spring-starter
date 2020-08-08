package com.tallon.repository.core.domain;

import com.tallon.common.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author Tallon
 * @since 2020-08-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("core_post")
public class CorePost extends BaseDomain {

	private static final long serialVersionUID = 3289350579429329036L;
	/**
	 * 对应作者 ID
	 */
	private Long postAuthor;

	/**
	 * 正文
	 */
	private String postContent;

	/**
	 * 标题
	 */
	@NotBlank(message = "标题为必填项")
	private String postTitle;

	/**
	 * 摘要
	 */
	private String postExcerpt;

	/**
	 * 文章状态：publish(发布) draft(草稿)
	 */
	private String postStatus;

	/**
	 * 评论状态：open(开放) closed(关闭)
	 */
	private String commentStatus;

	/**
	 * 文章缩略名
	 */
	private String postName;

	/**
	 * 文章内容过滤
	 */
	private String postContentFiltered;

	/**
	 * 父文章
	 */
	private Long postParent;

	/**
	 * 唯一标识符(短链接)
	 */
	private String guid;

	/**
	 * 排序
	 */
	private Integer menuOrder;

	/**
	 * 文章类型：post(文章) technology(技术) tools(工具) books(书籍)
	 */
	private String postType;

	/**
	 * MIME 类型
	 */
	private String postMimeType;

	/**
	 * 评论总数
	 */
	private Long commentCount;

}