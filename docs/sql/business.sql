CREATE TABLE `core_admin`
(
    `id`          bigint unsigned                                               NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username`    varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '登录名',
    `password`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '密码',
    `nickname`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '昵称',
    `email`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '邮箱',
    `url`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '网址',
    `status`      int unsigned                                                  NOT NULL DEFAULT '0' COMMENT '用户状态：1(已启用) 0(已禁用)',
    `is_deleted`  int unsigned                                                  NOT NULL DEFAULT '0' COMMENT '逻辑删除：1(已删除) 0(未删除)',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '修改时间',
    PRIMARY KEY `pk_id` (`id`),
    UNIQUE KEY `uk_username` (`username`),
    UNIQUE KEY `uk_nickname` (`nickname`),
    UNIQUE KEY `uk_email` (`email`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='管理员表';

CREATE TABLE `core_user`
(
    `id`             bigint unsigned                                               NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username`       varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '登录名',
    `password`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '密码',
    `nickname`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT '' COMMENT '昵称',
    `email`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '邮箱',
    `url`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '网址',
    `status`         int unsigned                                                  NOT NULL DEFAULT '0' COMMENT '用户状态：1(已启用) 0(已禁用)',
    `activation_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '激活码',
    `is_deleted`     int unsigned                                                  NOT NULL DEFAULT '0' COMMENT '逻辑删除：1(已删除) 0(未删除)',
    `create_time`    datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time`    datetime                                                      NOT NULL COMMENT '修改时间',
    PRIMARY KEY `pk_id` (`id`),
    UNIQUE KEY `uk_username` (`username`),
    UNIQUE KEY `uk_nickname` (`nickname`),
    UNIQUE KEY `uk_email` (`email`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='用户表'

CREATE TABLE `core_post`
(
    `id`                    bigint unsigned                                               NOT NULL AUTO_INCREMENT COMMENT '主键',
    `post_author`           bigint unsigned                                               NOT NULL DEFAULT '0' COMMENT '对应作者 ID',
    `post_content`          longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci     NOT NULL COMMENT '正文',
    `post_title`            text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci         NOT NULL COMMENT '标题',
    `post_excerpt`          text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci         NOT NULL COMMENT '摘要',
    `post_status`           varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT 'publish' COMMENT '文章状态：publish(发布) draft(草稿)',
    `comment_status`        varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT 'open' COMMENT '评论状态：open(开放) closed(关闭)',
    `post_name`             varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '文章缩略名',
    `post_content_filtered` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci     NOT NULL COMMENT '文章内容过滤',
    `post_parent`           bigint unsigned                                               NOT NULL DEFAULT '0' COMMENT '父文章',
    `guid`                  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '唯一标识符(短链接)',
    `menu_order`            int unsigned                                                  NOT NULL DEFAULT '0' COMMENT '排序',
    `post_type`             varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL DEFAULT 'post' COMMENT '文章类型：post(文章) technology(技术) tools(工具) books(书籍)',
    `post_mime_type`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'MIME 类型',
    `comment_count`         bigint unsigned                                               NOT NULL DEFAULT '0' COMMENT '评论总数',
    `create_time`           datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time`           datetime                                                      NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`),
    KEY `idx_post_name` (`post_name`),
    KEY `idx_type_status_date` (`post_type`, `post_status`, `create_time`, `id`),
    KEY `idx_post_parent` (`post_parent`),
    KEY `idx_post_author` (`post_author`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='文章表'
