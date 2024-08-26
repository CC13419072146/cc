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

 Date: 11/08/2023 12:59:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `item_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '订单项',
  `pro_no` varchar(255) NOT NULL COMMENT '商品号',
  `pro_count` bigint(0) NOT NULL COMMENT '商品数量',
  `temp_price` decimal(10, 2) NOT NULL COMMENT '此项总价',
  `order_no` varchar(255) NOT NULL COMMENT '所属订单',
  `user_no` varchar(50) NOT NULL COMMENT '购物人',
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES (1, 'e5152b15-31ef-4985-8bdd-e8a5691f348f', 1, 998.00, 'd4789443-15a8-4692-b6bf-1e5c15606d8d', 'desi1');

SET FOREIGN_KEY_CHECKS = 1;
