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

 Date: 11/08/2023 13:02:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_del
-- ----------------------------
DROP TABLE IF EXISTS `sys_del`;
CREATE TABLE `sys_del`  (
  `del_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '配送单',
  `del_name` varchar(50) NOT NULL COMMENT '配送人',
  `del_phone` bigint(0) NOT NULL COMMENT '配送人电话',
  `del_address` varchar(255) NOT NULL COMMENT '配送起始地址',
  `order_no` varchar(255) NOT NULL COMMENT '配送订单',
  `del_state` varchar(50) NOT NULL COMMENT '配送状态',
  `user_no` varchar(50) NOT NULL COMMENT '所属店铺',
  PRIMARY KEY (`del_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_del
-- ----------------------------
INSERT INTO `sys_del` VALUES (1, '123', 123, '北平', 'ssssss', '已送达', 'shop1');

SET FOREIGN_KEY_CHECKS = 1;
