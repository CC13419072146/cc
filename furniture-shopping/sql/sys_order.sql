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

 Date: 11/08/2023 13:03:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_order
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order`  (
  `order_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '订单表主键',
  `order_no` varchar(255) NOT NULL COMMENT '订单号',
  `fa_address` varchar(255) NOT NULL COMMENT '发货地址',
  `re_address` varchar(255) NOT NULL COMMENT '收货地址',
  `re_name` varchar(50) NOT NULL COMMENT '收货人名',
  `re_phone` bigint(0) NOT NULL COMMENT '收货电话',
  `sum_price` decimal(10, 2) NOT NULL COMMENT '总价',
  `order_state` varchar(255) NOT NULL COMMENT '订单状态',
  `order_notes` varchar(255) NULL DEFAULT NULL COMMENT '备注',
  `user_no` varchar(50) NOT NULL COMMENT '商家号',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order
-- ----------------------------
INSERT INTO `sys_order` VALUES (1, 'ssssss', 'sssssss', 'sssss', 'ssss', 1233244, 345.00, '已发货', '9876', 'shop1');
INSERT INTO `sys_order` VALUES (2, 'd4789443-15a8-4692-b6bf-1e5c15606d8d', 'temp', 'temp', 'temp', 123, 0.00, '虚拟暂存单', NULL, 'desi1');

SET FOREIGN_KEY_CHECKS = 1;
