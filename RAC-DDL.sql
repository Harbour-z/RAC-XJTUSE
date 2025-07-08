DROP SCHEMA IF EXISTS XJTUSE_RAC;
CREATE SCHEMA IF NOT EXISTS `XJTUSE_RAC` DEFAULT CHARACTER SET utf8 ;
USE `XJTUSE_RAC` ;

DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info(
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id' ,
    `username` VARCHAR(64) NOT NULL  COMMENT '登录名称' ,
    `password` VARCHAR(128) NOT NULL  COMMENT '登录密码' ,
    `phone` VARCHAR(20) NOT NULL  COMMENT '用户手机号' ,
    `user_gender` tinyint unsigned NOT NULL DEFAULT 0 COMMENT '用户性别;1为男 2为女 0-未知' ,
    `user_avatar` VARCHAR(255)   COMMENT '用户头像;头像资源地址' ,
    `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT 1 COMMENT '用户状态;0-正常 1-删除' ,
    `create_time` DATETIME NOT NULL  COMMENT '创建时间' ,
    `update_time` DATETIME NOT NULL  COMMENT '更新时间' ,
    `birthday` DATETIME   COMMENT '用户生日' ,
    `signature` VARCHAR(255)   COMMENT '个性签名' ,
    `email` VARCHAR(128)   COMMENT '用户邮箱' ,
    `profile_visible` tinyint(1) unsigned   COMMENT '用户资料可见性' ,
    `favorite_visible` tinyint(1) unsigned   COMMENT '收藏是否可见' ,
    PRIMARY KEY (id)
)  COMMENT = '用户信息';

DROP TABLE IF EXISTS admin_info;
CREATE TABLE admin_info(
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '管理员ID' ,
    `username` VARCHAR(50) NOT NULL  COMMENT '管理员账号' ,
    `password` VARCHAR(255) NOT NULL  COMMENT '密码' ,
    `avatar` VARCHAR(255)   COMMENT '管理员头像;头像资源URL' ,
    `create_time` DATETIME NOT NULL  COMMENT '' ,
    `update_time` DATETIME NOT NULL  COMMENT '' ,
    `phone` VARCHAR(20)   COMMENT '' ,
    `email` VARCHAR(255)   COMMENT '' ,
    `is_deleted` tinyint(1) unsigned NOT NULL  COMMENT '' ,
    PRIMARY KEY (id)
)  COMMENT = '管理员信息表';

DROP TABLE IF EXISTS user_favorite;
CREATE TABLE user_favorite(
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '' ,
    `user_id` bigint unsigned NOT NULL  COMMENT '用户ID' ,
    `merchant_id` bigint unsigned NOT NULL  COMMENT '被收藏商家ID' ,
    `create_time` DATETIME NOT NULL  COMMENT '' ,
    `update_time` DATETIME NOT NULL  COMMENT '' ,
    `merchant_tag` tinyint(1) unsigned NOT NULL  COMMENT '对被收藏商户的tag(0-待探索 1-常去 2-备选 3-不感兴趣)' ,
    `is_deleted` tinyint(1) unsigned NOT NULL  COMMENT '' ,
    PRIMARY KEY (id)
)  COMMENT = '用户收藏表';

DROP TABLE IF EXISTS merchant_category;
CREATE TABLE merchant_category(
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '' ,
    `parent_id` INT NOT NULL  COMMENT '父分类ID(若为0则其自身为一个父分类)' ,
    `name` VARCHAR(50) NOT NULL  COMMENT '分类名称' ,
    `icon` VARCHAR(255)   COMMENT '分类图标url' ,
    `is_deleted` tinyint(1) unsigned NOT NULL  COMMENT '状态(0-禁用, 1-启用)' ,
    `create_time` DATETIME NOT NULL  COMMENT '' ,
    `update_time` DATETIME NOT NULL  COMMENT '' ,
    PRIMARY KEY (id)
)  COMMENT = '商家分类表';

DROP TABLE IF EXISTS merchant_info;
CREATE TABLE merchant_info(
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '商户ID' ,
    `username` VARCHAR(64) NOT NULL  COMMENT '用户名' ,
    `password` VARCHAR(255) NOT NULL  COMMENT '密码' ,
    `email` VARCHAR(255)   COMMENT '' ,
    `phone` VARCHAR(20) NOT NULL  COMMENT '联系方式' ,
    `category_id` INT NOT NULL  COMMENT '店铺分类' ,
    `address` VARCHAR(255) NOT NULL  COMMENT '店铺地址' ,
    `merchant_name` VARCHAR(64) NOT NULL  COMMENT '店铺名称' ,
    `logitude` DECIMAL   COMMENT '经度' ,
    `latitude` DECIMAL   COMMENT '纬度' ,
    `avg_rating` DECIMAL   COMMENT '平均评分' ,
    `description` VARCHAR(255)   COMMENT '店铺简介' ,
    `cover` VARCHAR(255)   COMMENT '封面URL' ,
    `is_deleted` tinyint(1) unsigned NOT NULL  COMMENT '' ,
    `create_time` DATETIME NOT NULL  COMMENT '' ,
    `update_time` DATETIME NOT NULL  COMMENT '' ,
    `price_range` VARCHAR(255)   COMMENT '价格区间' ,
    `tag` VARCHAR(255)   COMMENT '商家标签' ,
    PRIMARY KEY (id)
)  COMMENT = '商家信息表';

DROP TABLE IF EXISTS merchant_qulification;
CREATE TABLE merchant_qulification(
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '' ,
    `merchant_id` bigint unsigned NOT NULL  COMMENT '' ,
    `license_number` VARCHAR(255)   COMMENT '营业许可证编号' ,
    `license` VARCHAR(255)   COMMENT '许可证图片url' ,
    `other_permit` VARCHAR(255)   COMMENT '其余资质许可图片(JSON)' ,
    `create_time` DATETIME NOT NULL  COMMENT '' ,
    `update_time` DATETIME NOT NULL  COMMENT '' ,
    `health` VARCHAR(255)   COMMENT '卫生许可证图片' ,
    `status` tinyint(1) unsigned NOT NULL  COMMENT '审核进度((0-待审核,1-审核中,2-审核通过,3-审核不通过,4-已冻结))' ,
    `reject_reason` VARCHAR(255)   COMMENT '拒绝原因' ,
    `is_deleted` tinyint(1) unsigned NOT NULL  COMMENT '' ,
    PRIMARY KEY (id)
)  COMMENT = '商家资质审核表';

DROP TABLE IF EXISTS merchant_hours_delivery;
CREATE TABLE merchant_hours_delivery(
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '' ,
    `merchant_id` tinyint unsigned NOT NULL  COMMENT '' ,
    `week_day` tinyint unsigned NOT NULL  COMMENT '工作天数' ,
    `open_time` time NOT NULL  COMMENT '营业开始时间' ,
    `close_time` time NOT NULL  COMMENT '打烊时间' ,
    `radius` DECIMAL   COMMENT '配送半径' ,
    `min_amount` DECIMAL   COMMENT '起送金额' ,
    `delivery_fee` DECIMAL   COMMENT '配送费' ,
    `create_time` DATETIME NOT NULL  COMMENT '' ,
    `update_time` DATETIME NOT NULL  COMMENT '' ,
    `is_deleted` tinyint(1) unsigned NOT NULL  COMMENT '' ,
    PRIMARY KEY (id)
)  COMMENT = '商家工作时间与配送范围';

DROP TABLE IF EXISTS comment;
CREATE TABLE comment(
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '评论id' ,
    `user_id` bigint unsigned NOT NULL  COMMENT '' ,
    `merchant_id` bigint unsigned NOT NULL  COMMENT '' ,
    `content` TEXT NOT NULL  COMMENT '内容' ,
    `overall_rating` DECIMAL NOT NULL  COMMENT '总体评分' ,
    `status` tinyint(1) unsigned NOT NULL  COMMENT '状态(0-待审核,1-审核通过,2-审核不通过)' ,
    `reject_reason` TEXT   COMMENT '审核被拒绝原因' ,
    `create_time` DATETIME NOT NULL  COMMENT '' ,
    `update_time` DATETIME NOT NULL  COMMENT '' ,
    `picture` VARCHAR(255)   COMMENT '图片url JSON' ,
    `video` VARCHAR(255)   COMMENT '视频url JSON' ,
    `is_deleted` tinyint(1) unsigned NOT NULL  COMMENT '' ,
    PRIMARY KEY (id)
)  COMMENT = '评论表';

DROP TABLE IF EXISTS rating_dimension;
CREATE TABLE rating_dimension(
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '' ,
    `comment_id` bigint unsigned   COMMENT '评论id' ,
    `rating_env` DECIMAL   COMMENT '环境评分' ,
    `rating_service` DECIMAL   COMMENT '服务评分' ,
    `rating_flavor` DECIMAL   COMMENT '口味评分' ,
    `create_time` DATETIME NOT NULL  COMMENT '' ,
    `update_time` DATETIME NOT NULL  COMMENT '' ,
    `is_deleted` tinyint(1) unsigned NOT NULL  COMMENT '' ,
    PRIMARY KEY (id)
)  COMMENT = '评分维度表';

DROP TABLE IF EXISTS comment_reply;
CREATE TABLE comment_reply(
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '' ,
    `comment_id` bigint unsigned NOT NULL  COMMENT '' ,
    `user_id` bigint unsigned NOT NULL  COMMENT '' ,
    `merchant_id` bigint unsigned NOT NULL  COMMENT '' ,
    `content` TEXT NOT NULL  COMMENT '' ,
    `create_time` DATETIME NOT NULL  COMMENT '' ,
    `update_time` DATETIME NOT NULL  COMMENT '' ,
    `is_deleted` tinyint(1) unsigned NOT NULL  COMMENT '' ,
    PRIMARY KEY (id)
)  COMMENT = '评论回复表';

DROP TABLE IF EXISTS merchant_content;
CREATE TABLE merchant_content(
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '' ,
    `merchant_id` bigint unsigned NOT NULL  COMMENT '商家id' ,
    `titile` VARCHAR(128) NOT NULL  COMMENT '发布内容的标题' ,
    `content` TEXT NOT NULL  COMMENT '商家发布的内容' ,
    `content_type` tinyint(1) unsigned NOT NULL  COMMENT '类型(1-新品预告,2-优惠活动,3-店铺故事,4-厨师风采)' ,
    `view_count` bigint unsigned NOT NULL  COMMENT '阅读量' ,
    `like_count` bigint unsigned NOT NULL  COMMENT '点赞数' ,
    `comment_count` bigint unsigned NOT NULL  COMMENT '评论数' ,
    `create_time` DATETIME NOT NULL  COMMENT '' ,
    `update_time` DATETIME NOT NULL  COMMENT '' ,
    `picture` VARCHAR(255)   COMMENT '图片url' ,
    `video` VARCHAR(255)   COMMENT '视频url' ,
    `is_deleted` tinyint(1) unsigned   COMMENT '' ,
    PRIMARY KEY (id)
)  COMMENT = '商家内容';

DROP TABLE IF EXISTS user_browse_history;
CREATE TABLE user_browse_history(
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '' ,
    `user_id` bigint unsigned NOT NULL  COMMENT '' ,
    `merchant_id` bigint unsigned NOT NULL  COMMENT '' ,
    `browse_time` DATETIME   COMMENT '浏览时间' ,
    `stay_duration` bigint unsigned   COMMENT '停留时长' ,
    `create_time` DATETIME NOT NULL  COMMENT '' ,
    `update-time` DATETIME NOT NULL  COMMENT '' ,
    `is_deleted` tinyint(1) unsigned NOT NULL  COMMENT '' ,
    PRIMARY KEY (id)
)  COMMENT = '用户浏览历史表';

DROP TABLE IF EXISTS admin_audit_log;
CREATE TABLE admin_audit_log(
    `id` INT AUTO_INCREMENT COMMENT '' ,
    `admin_id` bigint unsigned NOT NULL  COMMENT '' ,
    `audit_type` tinyint(1) unsigned NOT NULL  COMMENT '审核类型(1-商家注册,2-商家信息修改,3-评论内容,4-商家动态)' ,
    `target_id` bigint unsigned NOT NULL  COMMENT '审核对象ID(商家ID/评论ID/动态ID)' ,
    `old_status` tinyint(1) unsigned NOT NULL  COMMENT '审核前状态' ,
    `new_status` tinyint(1) unsigned   COMMENT '审核后状态' ,
    `audit_remark` TEXT   COMMENT '审核备注(拒绝原因等)' ,
    `create_time` DATETIME NOT NULL  COMMENT '' ,
    `update_time` DATETIME NOT NULL  COMMENT '' ,
    `is_deleted` tinyint(1) unsigned NOT NULL  COMMENT '' ,
    PRIMARY KEY (id)
)  COMMENT = '审核日志表';

