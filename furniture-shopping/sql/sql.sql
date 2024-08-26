/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : furniture_shopping

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2023-09-13 10:39:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `desi_pro`
-- ----------------------------
DROP TABLE IF EXISTS `desi_pro`;
CREATE TABLE `desi_pro` (
`desi_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '设计师方案' ,
`desi_url`  varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '方案图' ,
`desi_title`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '方案标题' ,
`desi_desc`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '方案描述' ,
`user_no`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设计师账号' ,
PRIMARY KEY (`desi_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
AUTO_INCREMENT=4

;

-- ----------------------------
-- Records of desi_pro
-- ----------------------------
BEGIN;
INSERT INTO `desi_pro` VALUES ('1', 'https://img1.baidu.com/it/u=2274788698,1262022827&fm=253&fmt=auto&app=138&f=JPEG?w=531&h=500', '最新人工学椅子', '采用德国类人集团最新研发成果，长期使用不仅能活血化瘀，亦能开阔身心', 'desi1'), ('2', 'https://img0.baidu.com/it/u=3623961695,2650345237&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=313', '手绘概念沙发设计', '借鉴文艺复兴思想绘制而成', 'desi1'), ('3', '/api/file/download?fileName=d0d93adce0514cc4b5e4ee6c03fba229.jpeg', 'aaww', 'dfw', 'desi1');
COMMIT;

-- ----------------------------
-- Table structure for `order_item`
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
`item_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单项' ,
`pro_no`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品号' ,
`pro_count`  bigint(20) NOT NULL COMMENT '商品数量' ,
`temp_price`  decimal(10,2) NOT NULL COMMENT '此项总价' ,
`order_no`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属订单' ,
`user_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '购物人' ,
PRIMARY KEY (`item_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=44

;

-- ----------------------------
-- Records of order_item
-- ----------------------------
BEGIN;
INSERT INTO `order_item` VALUES ('1', 'e5152b15-31ef-4985-8bdd-e8a5691f348f', '1', '998.00', 'd4789443-15a8-4692-b6bf-1e5c15606d8d', 'desi1');
COMMIT;

-- ----------------------------
-- Table structure for `pro_shop`
-- ----------------------------
DROP TABLE IF EXISTS `pro_shop`;
CREATE TABLE `pro_shop` (
`pro_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品表主键' ,
`pro_no`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品编号' ,
`pro_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名' ,
`unit_price`  decimal(10,2) NOT NULL COMMENT '单价' ,
`pro_desc`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品描述' ,
`pro_url`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品图' ,
`user_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属店铺' ,
`inventory`  bigint(20) NOT NULL COMMENT '库存' ,
PRIMARY KEY (`pro_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=10

;

-- ----------------------------
-- Records of pro_shop
-- ----------------------------
BEGIN;
INSERT INTO `pro_shop` VALUES ('2', 'e5152b15-31ef-4985-8bdd-e8a5691f348f', '资深大理石桌子', '998.00', '超级耐看且耐用的大理石桌子', '/api/file/download?fileName=42b9ac9acd4f49ef8329bacb7a2e0c44.jpeg', 'shop1', '95'), ('3', 'sad2h-sad88-mv7', '蓝博湾重金设计打造', '889.00', '超级好看，高级感点满', 'https://img1.baidu.com/it/u=3305144007,2305186064&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500', 'shop5', '86'), ('4', 'ksansa9-sakfsnd8-je8h47fsg6', '居有会良心良心家具', '650.00', '宝宝，孕妇专用，舒适柔软，极具亲和力', 'https://img1.baidu.com/it/u=2631724342,843333302&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500', 'shop2', '78'), ('5', 'sad-ksafa9-67g65-asdhw0', '宜家伊娃内阁设计', '440.00', '家用商用都妥妥的上气质', 'https://img0.baidu.com/it/u=1302112766,2488913521&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500', 'shop3', '35'), ('6', 'dsad0-fasasd0fsa--asfkmj97hfw8-afs', '黄花梨月洞门仿古床', '1600.00', '闺房专用，送礼装修老一辈一眼拿下', 'https://img0.baidu.com/it/u=428757554,4085175470&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=771', 'shop4', '14'), ('8', '7c147c73-68ba-4ce8-9b0a-959065fdbd30', '11', '11.00', '11', '/api/file/download?fileName=91e9a2cfb0fc4336808965a8bd2177cb.jpg', 'shop1', '10');
COMMIT;

-- ----------------------------
-- Table structure for `sys_chat`
-- ----------------------------
DROP TABLE IF EXISTS `sys_chat`;
CREATE TABLE `sys_chat` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
`sender`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息发送者' ,
`receiver`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息接收者' ,
`chat_date`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息发送时间' ,
`is_read`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否已读, 0: 未读, 1: 已读' ,
`content`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息内容' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=82

;

-- ----------------------------
-- Records of sys_chat
-- ----------------------------
BEGIN;
INSERT INTO `sys_chat` VALUES ('60', 'user1', 'shop1', '2023-09-12 09:37:47', '1', 'aa\n'), ('61', 'user1', 'shop1', '2023-09-12 09:39:25', '1', 'bb\n'), ('62', 'user1', 'shop1', '2023-09-12 09:39:33', '1', 'abc\n'), ('63', 'user1', 'shop2', '2023-09-12 09:44:56', '0', 'abc\n'), ('64', 'user1', 'shop2', '2023-09-12 09:44:59', '0', 'qqq\n'), ('65', 'user1', 'shop4', '2023-09-12 09:45:07', '0', 'qqq\n'), ('66', 'user1', 'shop5', '2023-09-12 09:45:11', '0', 'qqq\n'), ('67', 'user1', 'shop3', '2023-09-12 09:52:29', '0', 'abc'), ('68', 'user1', 'shop5', '2023-09-12 09:52:42', '0', 'abc\n'), ('69', 'user1', 'shop2', '2023-09-12 10:01:54', '0', 'abc\n'), ('70', 'user1', 'shop4', '2023-09-12 10:01:58', '0', 'aaa\n'), ('71', 'user1', 'shop1', '2023-09-12 10:02:05', '1', 'wewe\n'), ('72', 'user1', 'shop3', '2023-09-12 10:02:16', '0', 'abc\n'), ('73', 'user1', 'shop4', '2023-09-12 10:09:09', '0', 'aab\n'), ('74', 'user1', 'shop4', '2023-09-12 10:09:15', '0', 'aa\n'), ('75', 'user1', 'shop5', '2023-09-12 10:09:18', '0', 'cc\n'), ('76', 'user1', 'shop3', '2023-09-12 10:09:23', '0', 'bb\n'), ('77', 'user1', 'shop2', '2023-09-12 10:10:00', '0', 'aa\n'), ('78', 'shop1', 'user1', '2023-09-12 10:13:37', '1', 'bb'), ('79', 'shop1', 'user1', '2023-09-12 10:13:39', '1', 'cc'), ('80', 'user1', 'desi1', '2023-09-13 10:11:38', '1', 'fdfd'), ('81', 'desi1', 'user1', '2023-09-13 10:11:52', '1', 'dfghjk\n');
COMMIT;

-- ----------------------------
-- Table structure for `sys_comment`
-- ----------------------------
DROP TABLE IF EXISTS `sys_comment`;
CREATE TABLE `sys_comment` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
`msg_id`  bigint(20) NOT NULL COMMENT '论坛ID' ,
`user_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论人' ,
`content`  varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论内容' ,
`comment_date`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=19

;

-- ----------------------------
-- Records of sys_comment
-- ----------------------------
BEGIN;
INSERT INTO `sys_comment` VALUES ('1', '16', 'user1', 'abc', '2023-09-05 16:16:24'), ('2', '16', 'user1', 'xxx', '2023-09-05 16:16:36'), ('3', '15', 'user1', 'zxc', '2023-09-05 16:16:46'), ('4', '14', 'user1', '很美很美', '2023-09-05 16:17:09'), ('5', '16', 'user1', 'aaa', '2023-09-05 16:19:14'), ('6', '16', 'user1', '12312', '2023-09-05 16:19:33'), ('7', '16', 'user1', 'vvv', '2023-09-05 16:33:18'), ('8', '16', 'user1', 'vvv', '2023-09-05 16:37:17'), ('9', '16', 'user1', 'ABC', '2023-09-05 16:38:32'), ('10', '16', 'user1', 'ABCBB', '2023-09-05 16:38:41'), ('11', '15', 'user1', 'DDD', '2023-09-05 16:39:01'), ('12', '16', 'user1', 'aaee', '2023-09-05 16:39:59'), ('13', '15', 'user1', '121212', '2023-09-05 16:40:07'), ('14', '17', 'user1', 'ade', '2023-09-05 16:40:43'), ('15', '17', 'user1', 'ddd', '2023-09-06 09:01:06'), ('16', '16', 'user1', 'ss', '2023-09-12 10:09:39'), ('17', '18', 'user1', 'xcxc', '2023-09-12 13:53:15'), ('18', '21', 'desi1', '3344', '2023-09-13 08:51:22');
COMMIT;

-- ----------------------------
-- Table structure for `sys_del`
-- ----------------------------
DROP TABLE IF EXISTS `sys_del`;
CREATE TABLE `sys_del` (
`del_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '配送单' ,
`del_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配送人' ,
`del_phone`  bigint(20) NOT NULL COMMENT '配送人电话' ,
`del_address`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配送起始地址' ,
`order_no`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配送订单' ,
`del_state`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配送状态' ,
`user_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属店铺' ,
PRIMARY KEY (`del_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=2

;

-- ----------------------------
-- Records of sys_del
-- ----------------------------
BEGIN;
INSERT INTO `sys_del` VALUES ('1', '123', '123', '北平', 'ssssss', '已送达', 'shop1');
COMMIT;

-- ----------------------------
-- Table structure for `sys_msg`
-- ----------------------------
DROP TABLE IF EXISTS `sys_msg`;
CREATE TABLE `sys_msg` (
`msg_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息表' ,
`msg_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息类型，公共论坛、私人咨询' ,
`user_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发起人号' ,
`user_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发起人名' ,
`msg_date`  datetime NOT NULL COMMENT '发起时间' ,
`other_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对方号' ,
`msg_detail`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息内容' ,
`talk_picture`  varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '论坛交流上传的图片' ,
PRIMARY KEY (`msg_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=22

;

-- ----------------------------
-- Records of sys_msg
-- ----------------------------
BEGIN;
INSERT INTO `sys_msg` VALUES ('1', '私人咨询', 'user1', 'userwwww', '2023-08-10 11:05:34', 'shop1', '你好', null), ('3', '私人咨询', 'shop1', '轻奢旗舰店', '2023-08-10 11:17:59', 'user1', '你好，亲有什么需要吗', null), ('4', '公共论坛', 'desi1', '临渊', '2023-08-10 14:00:38', null, 'wwawawawawaw', null), ('5', '公共论坛', 'desi1', '临渊', '2023-08-11 10:59:57', null, '这是一条最新消息呀', null), ('6', '私人咨询', 'desi1', '临渊', '2023-08-11 11:00:40', 'shop1', '商家你好哇', null), ('7', '私人咨询', 'shop1', '轻奢旗舰店', '2023-08-11 11:01:39', 'desi1', '临渊设计师，你好', null), ('8', '公共论坛', 'user1', '里一辆', '2023-08-11 11:02:49', null, '咱好歹也说点啥', null), ('9', '私人咨询', 'user1', '里一辆', '2023-08-11 11:03:26', 'shop1', '没有什么需要，单纯拉拉话', null), ('10', '公共论坛', 'user1', '里4辆', '2023-08-31 17:16:16', null, '', null), ('11', '公共论坛', 'user1', '里4辆', '2023-08-31 17:20:19', null, '', null), ('21', '论坛交流', 'desi1', '临渊', '2023-09-13 08:51:06', '**', 'xxoo', 'c1f53d2fc3864dedb6eb4eba755b2d8a.jpeg');
COMMIT;

-- ----------------------------
-- Table structure for `sys_node`
-- ----------------------------
DROP TABLE IF EXISTS `sys_node`;
CREATE TABLE `sys_node` (
`node_id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`node_type`  bigint(20) NOT NULL ,
`node_desc`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`node_url`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`node_icon`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`node_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=34

;

-- ----------------------------
-- Records of sys_node
-- ----------------------------
BEGIN;
INSERT INTO `sys_node` VALUES ('1', '0', '用户管理', '/userMan.html', 'el-icon-s-custom'), ('2', '0', '设计师管理', '/designerMan.html', 'el-icon-s-opportunity'), ('3', '0', '店铺管理', '/shopMan.html', 'el-icon-price-tag'), ('13', '1', '商品管理', '/proMan.html', 'el-icon-set-up'), ('14', '1', '订单管理', '/orderMan.html', 'el-icon-bank-card\r\nel-icon-bank-card'), ('17', '2', '个人主页', '/sysUserCenter.html', 'el-icon-user'), ('18', '2', '设计方案', '/desiPic.html', 'el-icon-money\r\n'), ('19', '2', '在线论坛', '/pubMsg.html', 'el-icon-connection'), ('22', '2', '消息中心', '/chat.html', 'el-icon-chat-dot-square'), ('23', '3', '线上购物', '/smartPro.html', 'el-icon-shopping-cart-2'), ('25', '3', '购物车', '/tempPro.html', 'el-icon-shopping-cart-full'), ('26', '3', '我的订单', '/sysMyOrder.html', 'el-icon-s-order'), ('27', '3', '参考方案', '/visitPlan.html', 'el-icon-s-flag'), ('28', '3', '在线论坛', '/pubMsg.html', 'el-icon-connection'), ('29', '3', '个人中心', '/sysUserCenter.html', 'el-icon-user'), ('30', '3', '消息中心', '/chat.html', 'el-icon-chat-dot-square'), ('31', '1', '消息中心', '/chat.html', 'el-icon-chat-dot-square'), ('32', '1', '个人中心', '/sysUserCenter.html', 'el-icon-user'), ('33', '0', '论坛管理', '/talkMan.html', 'el-icon-chat-line-square');
COMMIT;

-- ----------------------------
-- Table structure for `sys_order`
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order` (
`order_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单表主键' ,
`order_no`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号' ,
`fa_address`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发货地址' ,
`re_address`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货地址' ,
`re_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人名' ,
`re_phone`  bigint(20) NOT NULL COMMENT '收货电话' ,
`sum_price`  decimal(10,2) NOT NULL COMMENT '总价' ,
`order_state`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态,0:待出库, 1:配送中, 2:待收货, 3:已完成, 4:取消订单, 5:确认取消' ,
`order_notes`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`user_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商家号' ,
`shop_count`  bigint(20) NULL DEFAULT NULL COMMENT '商品数量' ,
`shop_id`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品编号' ,
PRIMARY KEY (`order_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=19

;

-- ----------------------------
-- Records of sys_order
-- ----------------------------
BEGIN;
INSERT INTO `sys_order` VALUES ('15', '27a7f9a9bf4c4b8bad25b147370b2d62', '地址5', '地址2', 'user1', '13434344442', '650.00', '0', null, 'shop2', '1', 'ksansa9-sakfsnd8-je8h47fsg6'), ('16', 'be49b1bc64ff4bb6bf2d1755f5c6ce22', '地址6', '地址2', 'user1', '13434344442', '440.00', '0', null, 'shop3', '1', 'sad-ksafa9-67g65-asdhw0'), ('17', '20e5268eb815459ab4e182ab9f0bf15c', '地址3', '地址2', 'user1', '13434344442', '998.00', '5', null, 'shop1', '1', 'e5152b15-31ef-4985-8bdd-e8a5691f348f'), ('18', '642a64074ab94d2f9ceab4cf78ce8526', '地址3', '地址2', 'user1', '13434344442', '11.00', '3', null, 'shop1', '1', '7c147c73-68ba-4ce8-9b0a-959065fdbd30');
COMMIT;

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
`role_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色表主键' ,
`role_type`  bigint(20) NOT NULL COMMENT '角色标识' ,
`role_desc`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色描述' ,
PRIMARY KEY (`role_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=5

;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('1', '0', '管理员'), ('2', '1', '店铺'), ('3', '2', '设计师'), ('4', '3', '用户');
COMMIT;

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
`user_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户表主键' ,
`user_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名' ,
`user_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号' ,
`password`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码' ,
`role_type`  bigint(20) NOT NULL COMMENT '角色' ,
`signature`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '签名' ,
`address`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户地址' ,
`phone`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码' ,
`user_avatar`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像' ,
PRIMARY KEY (`user_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=38

;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', '王多鱼', 'root', '9O9Gf38LWWdKw+D2GwTlhA==', '0', '一位心大又豪横的管理员', '地址1', '13434344441', null), ('3', '里4辆', 'user1', 'k4ntHZmPhGjKOmIAe0lAoQ==', '3', '里一辆是铁，里一辆是刚', '地址2', '13434344442', '92c15393c6104883ab7643b00eb64296.jpg'), ('7', '轻奢旗舰店1', 'shop1', 'k4ntHZmPhGjKOmIAe0lAoQ==', '1', '当代隐性奢华家具城', '地址3', '13434344443', 'e171b5ca98d94d5d94ba61e54453a68b.jpg'), ('8', '临渊', 'desi1', 'k4ntHZmPhGjKOmIAe0lAoQ==', '2', '一位有伟大抱负，不断提升自己的艺术人', '地址4', '13434344444', 'ddd0cdc5d0b24b31a89b48922edc3384.jpg'), ('9', '简约木材城', 'shop2', 'k4ntHZmPhGjKOmIAe0lAoQ==', '1', '大隐隐于市，小隐隐于野', '地址5', '13434344445', null), ('10', '高端定制屋', 'shop3', 'k4ntHZmPhGjKOmIAe0lAoQ==', '1', '从选材到成品，为您量身打造专属家具', '地址6', '13434344446', '3dd8ac1135f749f4a15cff40b41cc7b9.jpg'), ('11', '平价特色坊', 'shop4', 'k4ntHZmPhGjKOmIAe0lAoQ==', '1', '价格亲民实惠，主打一个物美价廉，耐用持久', '地址7', '13434344447', null), ('12', '西域丝绸阁', 'shop5', 'k4ntHZmPhGjKOmIAe0lAoQ==', '1', '张骞当年出使西域带回的天竺打造工艺，打造属于您的专属雅痞家具', '地址8', '13434344448', null), ('13', '子安', 'desi2', 'k4ntHZmPhGjKOmIAe0lAoQ==', '2', '对古风痴迷到只为此而活', '地址9', '13434344449', null), ('14', '扶风', 'desi3', 'k4ntHZmPhGjKOmIAe0lAoQ==', '2', '追求极致简约风格，坚持断舍离的设计师', '地址10', '13434344410', null), ('15', '白凤', 'desi4', 'k4ntHZmPhGjKOmIAe0lAoQ==', '2', '痴迷于白色的极致设计师，只为设计出极致白的世界', '地址11', '13434344411', null), ('16', '诗染', 'desi5', 'k4ntHZmPhGjKOmIAe0lAoQ==', '2', '追求新事物，讲究中西方结合的协调美感', '地址12', '13434344412', null), ('17', '吴天天', 'user2', 'k4ntHZmPhGjKOmIAe0lAoQ==', '3', '这个人很懒，什么都没留下', '地址13', '13434344413', '5a7c0a0d865e4b77bf3a434d2e8fb8e0.jpeg'), ('18', '白团团', 'user3', 'k4ntHZmPhGjKOmIAe0lAoQ==', '3', '第二大懒人，愿望是永远躺平', '地址14', '13434344414', null), ('19', '东西西', 'user4', 'k4ntHZmPhGjKOmIAe0lAoQ==', '3', '懒到懒得和谁比更懒，完全懒到裂开', '地址15', '13434344415', null), ('20', '蓝胖胖', 'user5', 'k4ntHZmPhGjKOmIAe0lAoQ==', '3', '小废柴，有个好朋友叫大熊，他容易被胖虎欺负，他也是未来静香的丈夫', '地址16', '13434344416', null), ('33', 'aa', 'aa', 'aa', '3', '', '地址17', '13434344417', null), ('34', 'xxx', 'xxx', 'hGZ/xn1S/ejtu8oRz+mOkw==', '3', 'xxx', null, null, null);
COMMIT;

-- ----------------------------
-- Auto increment value for `desi_pro`
-- ----------------------------
ALTER TABLE `desi_pro` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for `order_item`
-- ----------------------------
ALTER TABLE `order_item` AUTO_INCREMENT=44;

-- ----------------------------
-- Auto increment value for `pro_shop`
-- ----------------------------
ALTER TABLE `pro_shop` AUTO_INCREMENT=10;

-- ----------------------------
-- Auto increment value for `sys_chat`
-- ----------------------------
ALTER TABLE `sys_chat` AUTO_INCREMENT=82;

-- ----------------------------
-- Auto increment value for `sys_comment`
-- ----------------------------
ALTER TABLE `sys_comment` AUTO_INCREMENT=19;

-- ----------------------------
-- Auto increment value for `sys_del`
-- ----------------------------
ALTER TABLE `sys_del` AUTO_INCREMENT=2;

-- ----------------------------
-- Auto increment value for `sys_msg`
-- ----------------------------
ALTER TABLE `sys_msg` AUTO_INCREMENT=22;

-- ----------------------------
-- Auto increment value for `sys_node`
-- ----------------------------
ALTER TABLE `sys_node` AUTO_INCREMENT=34;

-- ----------------------------
-- Auto increment value for `sys_order`
-- ----------------------------
ALTER TABLE `sys_order` AUTO_INCREMENT=19;

-- ----------------------------
-- Auto increment value for `sys_role`
-- ----------------------------
ALTER TABLE `sys_role` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `sys_user`
-- ----------------------------
ALTER TABLE `sys_user` AUTO_INCREMENT=38;


---新增 sql
alter table pro_shop add pro_cate varchar(50);

--用户状态 0: 禁用, 1：正常用户, 2: 审核中
alter table sys_user add user_status varchar(2) default '1';
alter table sys_user add business_license varchar(255);
