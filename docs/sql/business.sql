CREATE TABLE `core_admin`
(
    `id`          bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username`    varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '登录名',
    `password`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '密码',
    `nickname`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '昵称',
    `email`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '邮箱',
    `url`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '网址',
    `status`      int unsigned NOT NULL DEFAULT '0' COMMENT '用户状态：1(已启用) 0(已禁用)',
    `is_deleted`  int unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除：1(已删除) 0(未删除)',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '修改时间',
    PRIMARY KEY `pk_id` (`id`),
    UNIQUE KEY `uk_username` (`username`),
    UNIQUE KEY `uk_nickname` (`nickname`),
    UNIQUE KEY `uk_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='管理员表';

CREATE TABLE `core_user`
(
    `id`             bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username`       varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '登录名',
    `password`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '密码',
    `nickname`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '昵称',
    `email`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '邮箱',
    `url`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '网址',
    `status`         int unsigned NOT NULL DEFAULT '0' COMMENT '用户状态：1(已启用) 0(已禁用)',
    `activation_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '激活码',
    `is_deleted`     int unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除：1(已删除) 0(未删除)',
    `create_time`    datetime NOT NULL COMMENT '创建时间',
    `update_time`    datetime NOT NULL COMMENT '修改时间',
    PRIMARY KEY `pk_id` (`id`),
    UNIQUE KEY `uk_username` (`username`),
    UNIQUE KEY `uk_nickname` (`nickname`),
    UNIQUE KEY `uk_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表'


