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

 Date: 11/08/2023 13:03:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_node
-- ----------------------------
DROP TABLE IF EXISTS `sys_node`;
CREATE TABLE `sys_node`  (
  `node_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `node_type` bigint(0) NOT NULL,
  `node_desc` varchar(50) NOT NULL,
  `node_url` varchar(200) NOT NULL,
  PRIMARY KEY (`node_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_node
-- ----------------------------
INSERT INTO `sys_node` VALUES (1, 0, '用户管理', '/userMan.html');
INSERT INTO `sys_node` VALUES (2, 0, '设计师管理', '/designerMan.html');
INSERT INTO `sys_node` VALUES (3, 0, '店铺管理', '/shopMan.html');
INSERT INTO `sys_node` VALUES (13, 1, '商品管理', '/proMan.html');
INSERT INTO `sys_node` VALUES (14, 1, '订单管理', '/orderMan.html');
INSERT INTO `sys_node` VALUES (15, 1, '配送管理', '/delMan.html');
INSERT INTO `sys_node` VALUES (16, 1, '咨询回复', '/msgBack.html');
INSERT INTO `sys_node` VALUES (17, 2, '个人主页', '/desiSelf.html');
INSERT INTO `sys_node` VALUES (18, 2, '设计方案', '/desiPic.html');
INSERT INTO `sys_node` VALUES (19, 2, '在线论坛', '/pubMsg.html');
INSERT INTO `sys_node` VALUES (20, 2, '咨询回复', '/msgBack.html');
INSERT INTO `sys_node` VALUES (21, 2, '线上购物', '/starShop.html');
INSERT INTO `sys_node` VALUES (22, 2, '订单项暂存', '/tempPro.html');
INSERT INTO `sys_node` VALUES (23, 3, '家具推荐', '/smartPro.html');
INSERT INTO `sys_node` VALUES (24, 3, '线上购物', '/starShop.html');
INSERT INTO `sys_node` VALUES (25, 3, '订单项暂存', '/tempPro.html');
INSERT INTO `sys_node` VALUES (26, 3, '在线论坛', '/pubMsg.html');
INSERT INTO `sys_node` VALUES (27, 3, '咨询回复', '/msgBack.html');

SET FOREIGN_KEY_CHECKS = 1;
