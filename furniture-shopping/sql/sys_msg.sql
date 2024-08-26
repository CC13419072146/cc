/*
 Navicat Premium Data Transfer

 Source Server         : localhost-practice
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:5001
 Source Schema         : furniture_shopping

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 11/08/2023 13:02:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_msg
-- ----------------------------
DROP TABLE IF EXISTS `sys_msg`;
CREATE TABLE `sys_msg`  (
  `msg_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '消息表',
  `msg_type` varchar(50) NOT NULL COMMENT '消息类型，公共论坛、私人咨询',
  `user_no` varchar(50) NOT NULL COMMENT '发起人号',
  `user_name` varchar(50) NOT NULL COMMENT '发起人名',
  `msg_date` datetime(0) NOT NULL COMMENT '发起时间',
  `other_no` varchar(50) NULL DEFAULT NULL COMMENT '对方号',
  `msg_detail` varchar(255) NOT NULL COMMENT '消息内容',
  PRIMARY KEY (`msg_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_msg
-- ----------------------------
INSERT INTO `sys_msg` VALUES (1, '私人咨询', 'user1', 'userwwww', '2023-08-10 11:05:34', 'shop1', '你好');
INSERT INTO `sys_msg` VALUES (3, '私人咨询', 'shop1', '轻奢旗舰店', '2023-08-10 11:17:59', 'user1', '你好，亲有什么需要吗');
INSERT INTO `sys_msg` VALUES (4, '公共论坛', 'desi1', '临渊', '2023-08-10 14:00:38', NULL, 'wwawawawawaw');
INSERT INTO `sys_msg` VALUES (5, '公共论坛', 'desi1', '临渊', '2023-08-11 10:59:57', NULL, '这是一条最新消息呀');
INSERT INTO `sys_msg` VALUES (6, '私人咨询', 'desi1', '临渊', '2023-08-11 11:00:40', 'shop1', '商家你好哇');
INSERT INTO `sys_msg` VALUES (7, '私人咨询', 'shop1', '轻奢旗舰店', '2023-08-11 11:01:39', 'desi1', '临渊设计师，你好');
INSERT INTO `sys_msg` VALUES (8, '公共论坛', 'user1', '里一辆', '2023-08-11 11:02:49', NULL, '咱好歹也说点啥');
INSERT INTO `sys_msg` VALUES (9, '私人咨询', 'user1', '里一辆', '2023-08-11 11:03:26', 'shop1', '没有什么需要，单纯拉拉话');

SET FOREIGN_KEY_CHECKS = 1;
